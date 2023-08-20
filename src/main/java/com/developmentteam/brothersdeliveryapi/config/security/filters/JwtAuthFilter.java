package com.developmentteam.brothersdeliveryapi.config.security.filters;

import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ApiAuthException;
import com.developmentteam.brothersdeliveryapi.config.security.exception.CustomAuthEntryPoint;
import com.developmentteam.brothersdeliveryapi.providers.contracts.TokenProvider;
import com.developmentteam.brothersdeliveryapi.services.auth.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Slf4j
@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

   private final CustomAuthEntryPoint customAuthEntryPoint;
   private final CustomUserDetailsService customUserDetailsService;
   private final TokenProvider tokenProvider;

   @Override
   protected void doFilterInternal(
           @NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain
   ) throws ServletException, IOException {

      String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

      if (authorizationHeader == null) {
         filterChain.doFilter(request, response);
         return;
      }

      try {

         final String jwtToken = authorizationHeader.substring("Bearer ".length());
         final String username = this.tokenProvider.extractUsername(jwtToken);

         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         if (username != null && authentication == null) {

            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
            boolean requestTokenIsValid = this.tokenProvider.isTokenValid(jwtToken, userDetails);

            if (requestTokenIsValid) {

               AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                 userDetails, null, userDetails.getAuthorities()
               );

               var webAuthenticationDetails = new WebAuthenticationDetailsSource().buildDetails(request);
               authenticationToken.setDetails(webAuthenticationDetails);

               SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
         }

      } catch (ApiAuthException authException) {

         this.customAuthEntryPoint.commence(request, response, authException);
         return;
      }

      filterChain.doFilter(request, response);
   }
}
