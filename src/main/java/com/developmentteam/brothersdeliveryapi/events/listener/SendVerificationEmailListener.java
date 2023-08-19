package com.developmentteam.brothersdeliveryapi.events.listener;

import com.developmentteam.brothersdeliveryapi.events.event.SendVerificationEmailEvent;
import com.developmentteam.brothersdeliveryapi.services.auth.TransparentTokenService;
import com.developmentteam.brothersdeliveryapi.services.notification.MailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendVerificationEmailListener {

   private final MailService mailService;
   private final TransparentTokenService transparentTokenService;

   @Async
   @EventListener
   public void handleEvent(SendVerificationEmailEvent event) throws UnknownHostException, MessagingException {

      String ip = InetAddress.getLocalHost().getHostAddress();

      var token = this.transparentTokenService.generateToken(event.getUser());
      String link = event.getUriComponentsBuilder()
              .queryParam("token", token)
              .toUriString()
              .replace("localhost", ip);


      this.mailService.sendAccountVerificationEmail(event.getUser(), link);
   }

}
