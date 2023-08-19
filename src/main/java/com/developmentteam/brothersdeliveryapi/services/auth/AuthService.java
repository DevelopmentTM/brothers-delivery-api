package com.developmentteam.brothersdeliveryapi.services.auth;

import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ApiAuthException;
import com.developmentteam.brothersdeliveryapi.dto.application.ApiResponseMessage;
import com.developmentteam.brothersdeliveryapi.dto.request.auth.*;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.CheckResetCodeResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.ForgotPasswordResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.RefreshTokenResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.SignInResponse;
import com.developmentteam.brothersdeliveryapi.entities.auth.RefreshToken;
import com.developmentteam.brothersdeliveryapi.entities.auth.ResetCode;
import com.developmentteam.brothersdeliveryapi.entities.auth.Role;
import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import com.developmentteam.brothersdeliveryapi.entities.auth.enums.RoleEnum;
import com.developmentteam.brothersdeliveryapi.events.event.SendResetCodeEvent;
import com.developmentteam.brothersdeliveryapi.events.event.SendVerificationEmailEvent;
import com.developmentteam.brothersdeliveryapi.events.publisher.NotificationPublisher;
import com.developmentteam.brothersdeliveryapi.providers.contracts.TokenProvider;
import com.developmentteam.brothersdeliveryapi.repositories.auth.RoleRepository;
import com.developmentteam.brothersdeliveryapi.repositories.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

   private final AuthenticationManager authenticationManager;
   private final UserRepository userRepository;
   private final UserService userService;
   private final TokenProvider tokenProvider;
   private final PasswordEncoder passwordEncoder;
   private final RoleRepository roleRepository;
   private final NotificationPublisher notificationPublisher;
   private final TransparentTokenService transparentTokenService;
   private final ResetCodeService resetCodeService;
   private final RefreshTokenService refreshTokenService;

   public SignInResponse signIn(SignInRequest request) {

      var authenticatedUser = this.userRepository.findUserByUserEmail(request.userEmail())
              .orElseThrow(() -> new ApiAuthException("usuário não encontrado"));

      if ( !(this.passwordEncoder.matches(request.userPassword(), authenticatedUser.getPassword()))) {
         throw new ApiAuthException("senha incorreta");
      }

      var authentication = new UsernamePasswordAuthenticationToken(
              request.userEmail(), request.userPassword()
      );
      this.authenticationManager.authenticate(authentication);

      var generatedToken = this.tokenProvider.generateToken(authenticatedUser);

      return SignInResponse.toResponse(generatedToken);
   }

   public ApiResponseMessage signUn(SignUpRequest request) {

      boolean userExists = this.userRepository.existsUserByUserEmail(request.userEmail());
      if (userExists) {
         throw new ApiAuthException("email em uso por outro usuário");
      }

      String encryptedPassword = this.passwordEncoder.encode(request.userPassword());

      Role role = Role.builder().roleName(RoleEnum.ROLE_USER).build();
      Role roleSaved = this.roleRepository.save(role);

      User user = User.builder()
              .userFirstName(request.userFirstName())
              .userLastName(request.userLastName())
              .userEmail(request.userEmail())
              .userPassword(encryptedPassword)
              .userPhone(request.userPhone())
              .userCpf(request.userCpf())
              .userRoles(List.of(roleSaved))
              .build();

      User userSaved = this.userRepository.save(user);

      UriComponentsBuilder uri = ServletUriComponentsBuilder.fromCurrentContextPath()
              .path("/api/auth/confirm-registration");

      var event = SendVerificationEmailEvent.createEvent(userSaved, uri);
      this.notificationPublisher.onSendVerificationEmail(event);

      return ApiResponseMessage.of("Cadastro realizado com sucesso!");
   }

   public ApiResponseMessage confirmVerification(String token) {

      var data = this.transparentTokenService.readPublicData(token);

      boolean isExpired = transparentTokenService.isExpired(data);

      if (isExpired) throw new ApiAuthException("Token in expired");

      Optional<User> user = this.userRepository.findUserByUserEmail(data.email());

      if (user.isPresent()) {
         if (user.get().isEmailVerified()) {
            throw new ApiAuthException("confirm verification exception");
         }
      }

      KeyBasedPersistenceTokenService tokenService = transparentTokenService
              .getKeyBasedPersistenceTokenFromUser(user.get());

      tokenService.verifyToken(token);

      user.get().setEmailVerified(true);
      this.userRepository.save(user.get());

      return ApiResponseMessage.of("Email verificado com sucesso!");
   }

   public ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request) {
      User user = userRepository.findUserByUserEmail(request.email()).get();

      var event = SendResetCodeEvent.createEvent(user);
      notificationPublisher.onSendResetCode(event);

      return ForgotPasswordResponse.toResponse(
              "o código foi enviado para o email informado",
              user.getUserEmail()
      );
   }

   public CheckResetCodeResponse checkResetCode(CheckResetCodeRequest request) {

      ResetCode resetCode = resetCodeService
              .findResetCodeByEmailAndCode(request.email(), request.resetCode());

      resetCodeService.isValid(resetCode);
      resetCodeService.inactivateResetCode(resetCode);

      String generatedToken = transparentTokenService.generateToken(resetCode.getResetCodeUser());

      return CheckResetCodeResponse.toResponse(generatedToken);
   }

   public ApiResponseMessage resetPassword(ResetPasswordRequest request) {

      var data = transparentTokenService.readPublicData(request.resetToken());

      boolean isExpired = transparentTokenService.isExpired(data);

      if (isExpired) throw new ApiAuthException("Token in expired");

      User user = userRepository.findUserByUserEmail(data.email()).get();

      KeyBasedPersistenceTokenService tokenService = transparentTokenService
              .getKeyBasedPersistenceTokenFromUser(user);

      tokenService.verifyToken(request.resetToken());

      if (!(request.password().equalsIgnoreCase(request.confirmPassword()))) {
         throw new ApiAuthException("password incompativeis");
      }

      userService.changeThePassword(user, request.password());

      return ApiResponseMessage.of("sua senha foi redefinida com sucesso");
   }

   public RefreshTokenResponse refreshJwtToken(RefreshTokenRequest request) {

      RefreshToken storedRefreshToken = this.refreshTokenService.findByToken(request.refreshToken());

      return null;
   }

}
