package com.developmentteam.brothersdeliveryapi.services.notification;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.Instant;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class MailService {

   private final JavaMailSender javaMailSender;
   private final SpringTemplateEngine templateEngine;

   public void  sendAccountVerificationEmail(User user, String verificationLink) throws MessagingException {
      Context ctx = new Context(LocaleContextHolder.getLocale());
      ctx.setVariable("user", user);
      ctx.setVariable("verificationLink", verificationLink);

      String verificationTemplate = this.templateEngine.process("account-verification-email.html", ctx);
      this.sendMailTemplate(verificationTemplate, user.getUserEmail(), "Account Verification");
   }

   public void sendResetCodeEmail(User user, Integer resetCode) throws MessagingException {
      Context ctx = new Context(LocaleContextHolder.getLocale());
      ctx.setVariable("user", user);
      ctx.setVariable("resetCode", resetCode);

      String accountVerificationTemplate = templateEngine.process("reset-password-email.html", ctx);
      this.sendMailTemplate(accountVerificationTemplate, user.getUserEmail(), "Reset password");
   }

   private void sendMailTemplate(String mailTemplate, String to, String subject) throws MessagingException {

      MimeMessage message = this.javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message);

      helper.setFrom("java.development.tm@gmail.com");
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setSentDate(Date.from(Instant.now()));
      helper.setText(mailTemplate);

      this.javaMailSender.send(message);
   }
}
