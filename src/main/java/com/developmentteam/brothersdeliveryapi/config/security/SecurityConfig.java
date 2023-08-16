package com.developmentteam.brothersdeliveryapi.config.security;

import com.developmentteam.brothersdeliveryapi.config.security.exception.CustomAccessDeniedHandler;
import com.developmentteam.brothersdeliveryapi.config.security.exception.CustomAuthEntryPoint;
import com.developmentteam.brothersdeliveryapi.config.security.filters.JwtAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

   @Autowired
   private CustomAuthEntryPoint customAuthEntryPoint;

   @Autowired
   private CustomAccessDeniedHandler customAccessDeniedHandler;

   @Autowired
   private AuthenticationProvider authenticationProvider;

   @Autowired
   private JwtAuthFilter jwtAuthFilter;

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

         authRequest.requestMatchers("/api/auth/**").permitAll();
         authRequest.requestMatchers("/swagger-ui/**").permitAll();
         authRequest.requestMatchers("/brothers-delivery-api-docs/**").permitAll();

         authRequest.anyRequest().permitAll();
      });

//      httpSecurity.exceptionHandling()
//              .authenticationEntryPoint(customAuthEntryPoint)
//              .accessDeniedHandler(customAccessDeniedHandler);

      httpSecurity.sessionManagement(session ->
              session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

      httpSecurity.authenticationProvider(authenticationProvider)
              .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

      return httpSecurity.build();
   }

}
