package com.developmentteam.brothersdeliveryapi.events.listener;

import com.developmentteam.brothersdeliveryapi.entities.auth.ResetCode;
import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import com.developmentteam.brothersdeliveryapi.events.event.SendResetCodeEvent;
import com.developmentteam.brothersdeliveryapi.services.auth.ResetCodeService;
import com.developmentteam.brothersdeliveryapi.services.notification.MailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendResetCodeListener {

   private final MailService mailService;
   private final ResetCodeService resetCodeService;

   @Async
   @EventListener
   public void handleEvent(SendResetCodeEvent event) throws MessagingException {

      User userRegistered = event.getUser();
      ResetCode generatedResetCode = resetCodeService.generateResetCode(userRegistered);
      this.mailService.sendResetCodeEmail(userRegistered, generatedResetCode.getResetCode());

   }
}
