package com.developmentteam.brothersdeliveryapi.services.auth;

import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ApiAuthException;
import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ResourceNotFoundException;
import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.UserNotAuthenticatedException;
import com.developmentteam.brothersdeliveryapi.dto.application.ApiResponseMessage;
import com.developmentteam.brothersdeliveryapi.dto.request.auth.*;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.CheckResetCodeResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.ForgotPasswordResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.RefreshTokenResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.SignInResponse;
import com.developmentteam.brothersdeliveryapi.entities.auth.RefreshToken;
import com.developmentteam.brothersdeliveryapi.entities.auth.Role;
import com.developmentteam.brothersdeliveryapi.entities.auth.User;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

      User storedUser = this.userRepository.findUserByUserEmail(request.userEmail())
              .orElseThrow(() -> new ResourceNotFoundException("Email não cadastrado"));

      boolean match = this.passwordEncoder.matches(request.userPassword(), storedUser.getPassword());

      if (!(match)) throw new ApiAuthException("Senha incorreta");

      Authentication authentication = new UsernamePasswordAuthenticationToken(request.userEmail(), request.userPassword());
      this.authenticationManager.authenticate(authentication);

      // TODO: 20/12/2023 busca das roles do usuário apresenta o que impede seu mapeamento no payload do token
      String generatedToken = this.tokenProvider.generateToken(storedUser/*, Map.of("roles", storedUser.getUserRoles())*/);

      return SignInResponse.toResponse(generatedToken);
   }

   public ApiResponseMessage signUn(SignUpRequest request) {

      boolean userExists = this.userRepository.existsUserByUserEmail(request.userEmail());

      if (userExists) throw new ApiAuthException("Email em uso por um usuário já cadastrado");

      String encryptedPassword = this.passwordEncoder.encode(request.userPassword());

      Role role = this.roleRepository.findById(1L).orElseThrow(ResourceNotFoundException.msg("role não encontrada"));

      User user = User.builder()
              .userFirstName(request.userFirstName())
              .userLastName(request.userLastName())
              .userEmail(request.userEmail())
              .userPassword(encryptedPassword)
              .userPhone(request.userPhone())
              .userCpf(request.userCpf())
              .userRoles(List.of(role))
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

      User storedUser = this.userRepository.findUserByUserEmail(data.email())
              .orElseThrow(ResourceNotFoundException.msg("Usuário não cadastrado no sistema"));

      if (storedUser.isEmailVerified()) throw new ApiAuthException("Email já foi verificado");

      boolean isExpired = this.transparentTokenService.isExpired(data);

      if (isExpired) throw new ApiAuthException("Link expirado");

      KeyBasedPersistenceTokenService tokenService = transparentTokenService
              .getInstanceForUser(storedUser);

      tokenService.verifyToken(token);

      storedUser.setEmailVerified(true);
      this.userRepository.save(storedUser);

      return ApiResponseMessage.of("Email verificado com sucesso!");
   }

   public ApiResponseMessage resendVerificationLink() {
      return ApiResponseMessage.of("not implemented");
   }

   public ForgotPasswordResponse forgotPassword(ForgotPasswordRequest request) {

      User user = this.userRepository.findUserByUserEmail(request.email())
              .orElseThrow(ResourceNotFoundException.msg("Usuário não cadastrado no sistema"));

      var event = SendResetCodeEvent.createEvent(user);
      this.notificationPublisher.onSendResetCode(event);

      return ForgotPasswordResponse.toResponse(
              "o código foi enviado para o email informado",
              user.getUserEmail()
      );
   }

   public CheckResetCodeResponse checkResetCode(CheckResetCodeRequest request) {

      var resetCode = this.resetCodeService.findResetCodeByEmailAndCode(request.email(), request.resetCode());

      this.resetCodeService.isValid(resetCode);
      this.resetCodeService.inactivateResetCode(resetCode);

      String generatedResetToken = this.transparentTokenService.generateToken(resetCode.getResetCodeUser());

      return CheckResetCodeResponse.toResponse(generatedResetToken);
   }

   public ApiResponseMessage resetPassword(ResetPasswordRequest request) {

      var data = this.transparentTokenService.readPublicData(request.resetToken());

      User user = userRepository.findUserByUserEmail(data.email())
              .orElseThrow(ResourceNotFoundException.msg("Usuário não encontrado"));

      boolean isExpired = this.transparentTokenService.isExpired(data);

      if (isExpired) throw new ApiAuthException("Token expirado");

      KeyBasedPersistenceTokenService tokenService = this.transparentTokenService
              .getInstanceForUser(user);

      tokenService.verifyToken(request.resetToken());

      boolean passwordMatch = request.password().equalsIgnoreCase(request.confirmPassword());
      if (!passwordMatch) throw new ApiAuthException("Senhas incompatíveis");

      this.userService.changeThePassword(user, request.password());

      return ApiResponseMessage.of("sua senha foi redefinida com sucesso");
   }

   public RefreshTokenResponse refreshJwtToken(RefreshTokenRequest request) {

      RefreshToken storedRefreshToken = this.refreshTokenService.findByToken(request.refreshToken());

      this.refreshTokenService.isValid(storedRefreshToken);

      User user = storedRefreshToken.getRefreshTokenUser();

      String newJwtToken = this.tokenProvider.generateToken(user, Map.of("roles", user.getUserRoles()));

      RefreshToken refreshToken = this.refreshTokenService.generateRefreshToken(user);
      String rawRefreshToken = refreshToken.getRefreshToken();

      return RefreshTokenResponse.toResponse(newJwtToken, rawRefreshToken);
   }

   public static User getLoggedUser() {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

      if (Objects.nonNull(authentication)) {
         var objectPrincipal = authentication.getPrincipal();
         if (objectPrincipal instanceof User loggedUser) return loggedUser;
      }

      throw new UserNotAuthenticatedException("Nenhum usuário autenticado");
   }
}
