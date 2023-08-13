package com.developmentteam.brothersdeliveryapi.services.auth;

import com.developmentteam.brothersdeliveryapi.config.messages.ExceptionMessages;
import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ApiAuthException;
import com.developmentteam.brothersdeliveryapi.entities.auth.ResetCode;
import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import com.developmentteam.brothersdeliveryapi.repositories.auth.ResetCodeRepository;
import com.developmentteam.brothersdeliveryapi.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ResetCodeService {

   @Value("${app.auth.tokens.reset-code.expiration}")
   private Long expirationTime;

   private final ResetCodeRepository resetCodeRepository;

   @Transactional
   public ResetCode generateResetCode(User user) {
      this.disableAllResetCodesFromUser(user);
      var resetCode = createResetCode(user);
      return resetCodeRepository.save(resetCode);
   }

   public void isValid(ResetCode resetCode) {
      if (resetCode.getResetCodeExpiryAt().isBefore(LocalDateTime.now()))
         throw new ApiAuthException(ExceptionMessages.RESET_CODE_EXPIRED.prop());

      if (!resetCode.isResetCodeActive())
         throw new ApiAuthException(ExceptionMessages.RESET_CODE_ALREADY_USED.prop());
   }

   public ResetCode findResetCodeByEmailAndCode(String email, Integer code) {
      return resetCodeRepository.findResetPasswordCodeByEmailAndCode(email, code)
              .orElseThrow(() -> new ApiAuthException(ExceptionMessages.RESET_CODE_INVALID.prop()));
   }

   @Transactional
   public void inactivateResetCode(ResetCode resetCode) {
      resetCode.setResetCodeActive(false);
      resetCodeRepository.save(resetCode);
   }

   @Transactional
   public void disableAllResetCodesFromUser(User user) {
      resetCodeRepository.deactivateResetCodesForUser(user.getUserId());
   }

   private ResetCode createResetCode(User user) {
      return ResetCode.builder()
              .resetCodeUser(user)
              .resetCode(RandomUtils.generateResetCode())
              .resetCodeExpiryAt(LocalDateTime.from(Instant.now().plusMillis(expirationTime)))
              .resetCodeActive(true)
              .build();
   }
}
