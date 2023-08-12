package com.developmentteam.brothersdeliveryapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
      });

      httpSecurity.authorizeHttpRequests(requests -> {
//         requests.requestMatchers(
//                 AntPathRequestMatcher.antMatcher("/api/auth/**"),
//                 AntPathRequestMatcher.antMatcher("/swagger-ui/**"),
//                 AntPathRequestMatcher.antMatcher("/brothers-delivery-api-docs/**")
//         ).permitAll();

         requests.anyRequest().permitAll();
      });

      return httpSecurity.build();
   }

}
