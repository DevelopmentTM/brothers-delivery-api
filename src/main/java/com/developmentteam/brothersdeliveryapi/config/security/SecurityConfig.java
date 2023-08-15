package com.developmentteam.brothersdeliveryapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

      httpSecurity.cors();
      httpSecurity.csrf(AbstractHttpConfigurer::disable);

      httpSecurity.headers(header -> {
         header.frameOptions().sameOrigin();
         header.xssProtection();
         header.contentSecurityPolicy("script-src 'self'");
      });

      httpSecurity.authorizeHttpRequests(authRequest -> {

         authRequest.requestMatchers(HttpMethod.GET, "/api/**").permitAll();

         authRequest.requestMatchers("/swagger-ui/**").permitAll();
         authRequest.requestMatchers("/brothers-delivery-api-docs/**").permitAll();

         authRequest.anyRequest().denyAll();
      });

      return httpSecurity.build();
   }

}
