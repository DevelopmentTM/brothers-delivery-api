package com.developmentteam.brothersdeliveryapi.services.auth;

import com.developmentteam.brothersdeliveryapi.config.Messages.ExceptionMessages;
import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ApiAuthException;
import com.developmentteam.brothersdeliveryapi.entities.auth.RefreshToken;
import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import com.developmentteam.brothersdeliveryapi.repositories.auth.RefreshTokenRepository;
import com.developmentteam.brothersdeliveryapi.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

   @Value("${app.auth.tokens.refresh-token.expiration}")
   private Long refreshTokenDurationMs;

   private final RefreshTokenRepository refreshTokenRepository;

   public RefreshToken findByToken(String refreshToken) {
      return refreshTokenRepository.findByRefreshToken(refreshToken)
              .orElseThrow(() -> new ApiAuthException(ExceptionMessages.REFRESH_TOKEN_NOT_FOUND.prop()));
   }

   public RefreshToken generateRefreshToken(User user) {
      var newRefreshToken = createRefreshToken(user);
      return updateRefreshTokenFromUser(user, newRefreshToken);
   }

   public void isValid(RefreshToken refreshToken) {
      if (refreshToken.getRefreshTokenExpiryAt().isBefore(ChronoLocalDateTime.from(Instant.now())))
         throw new ApiAuthException(ExceptionMessages.REFRESH_TOKEN_EXPIRED.prop());
   }

   private RefreshToken createRefreshToken(User user) {
      return RefreshToken.builder()
              .refreshTokenUser(user)
              .refreshToken(RandomUtils.generateRandomToken())
              .refreshTokenExpiryAt(LocalDateTime.from(Instant.now().plusMillis(refreshTokenDurationMs)))
              .build();
   }

   @Transactional
   public RefreshToken updateRefreshTokenFromUser(User user, RefreshToken refreshToken) {
      var userRefreshToken = refreshTokenRepository.findRefreshTokenByUser(user.getUserId());

      if (userRefreshToken.isPresent()){
         RefreshToken storedRefreshTokenForUser = userRefreshToken.get();
         String newRefreshToken = refreshToken.getRefreshToken();

         storedRefreshTokenForUser.setRefreshToken(newRefreshToken);

         return refreshTokenRepository.save(userRefreshToken.get());
      }

      return refreshTokenRepository.save(refreshToken);
   }
}
