package com.developmentteam.brothersdeliveryapi.providers.contracts;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface TokenProvider {

   String generateToken(User user);
   String generateToken(User user, Map<String, Object> claims);
   boolean isTokenValid(String token, UserDetails userDetails);
   String extractUsername(String token);

}
