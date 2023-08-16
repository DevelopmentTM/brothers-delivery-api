package com.developmentteam.brothersdeliveryapi.config.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@Configuration
public class MailConfig {

   @Value("${app.mail.host}")
   private String host;

   @Value("${app.mail.port}")
   private Integer port;

   @Value("${app.mail.username}")
   private String username;

   @Value("${app.mail.password}")
   private String password;

   @Value("${app.mail.default-encoding}")
   private String defaultEncoding;

   @Value("${app.mail.protocol}")
   private String protocol;

   @Value("${app.mail.smtp.auth}")
   private String smtpAuth;

   @Value("${app.mail.smtp.starttls.enable}")
   private String smtpStarttlsEnable;

   @Value("${app.mail.debug}")
   private String debug;

   @Bean
   public JavaMailSender javaMailSender() {
      Properties javaMailProperties = new Properties();
      javaMailProperties.put("mail.transport.protocol", protocol);
      javaMailProperties.put("mail.smtp.auth", smtpAuth);
      javaMailProperties.put("mail.smtp.starttls.enable", smtpStarttlsEnable);
      javaMailProperties.put("mail.debug", debug);

      JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
      javaMailSender.setHost(host);
      javaMailSender.setPort(port);
      javaMailSender.setUsername(username);
      javaMailSender.setPassword(password);
      javaMailSender.setDefaultEncoding(defaultEncoding);
      javaMailSender.setJavaMailProperties(javaMailProperties);

      return javaMailSender;
   }

}
