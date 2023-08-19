package com.developmentteam.brothersdeliveryapi.services.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.token.KeyBasedPersistenceTokenService;
import org.springframework.security.core.token.SecureRandomFactoryBean;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Service
public class TransparentTokenService {

   public String generateToken(User user) {
      KeyBasedPersistenceTokenService tokenService = this.getKeyBasedPersistenceTokenFromUser(user);
      String email = user.getUserEmail();
      Token generatedToken = tokenService.allocateToken(email);
      return generatedToken.getKey();
   }

   public boolean isExpired(PublicData publicData) {
      Instant createdAt = new Date(publicData.timestamp).toInstant();
      Instant now = new Date().toInstant();
      return createdAt.plus((Duration.ofMinutes(5))).isBefore(now);
   }

   public KeyBasedPersistenceTokenService getKeyBasedPersistenceTokenFromUser(User user) {
      String secret = user.getUserPassword();
      KeyBasedPersistenceTokenService tokenService = new KeyBasedPersistenceTokenService();

      try {
         tokenService.setServerSecret(secret);
         tokenService.setServerInteger(32);
         tokenService.setSecureRandom(new SecureRandomFactoryBean().getObject());
      } catch (Exception e) {
         log.warn("error in generate secure random object");
      }

      return tokenService;
   }
   public PublicData readPublicData(String rawToken) {
      byte[] bytes = Base64.getDecoder().decode(rawToken);
      String rawTokenDecode = new String(bytes);

      String[] tokenParts = rawTokenDecode.split(":");
      Long timestamp = Long.parseLong(tokenParts[0]);
      String email = tokenParts[2];

      return PublicData.of(email, timestamp);
   }

   record PublicData(String email, Long timestamp ) {
      public static PublicData of(String email, Long timestamp) {
         return new PublicData(
                 email,
                 timestamp
         );
      }
   }
}
