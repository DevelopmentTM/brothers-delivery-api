package com.developmentteam.brothersdeliveryapi.providers;

import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ApiAuthException;
import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import com.developmentteam.brothersdeliveryapi.providers.contracts.TokenProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenProvider implements TokenProvider {

   @Value("${app.auth.tokens.jwt.secret}")
   public String secret;

   @Value("${app.auth.tokens.jwt.expiration}")
   public Long expiration;

   @Override
   public String generateToken(User user) {
      return generateToken(user, new HashMap<>());
   }

   @Override
   public String generateToken(User user, Map<String, Object> claims) {
      return Jwts.builder()
              .setClaims(claims)
              .setSubject(user.getUserEmail())
              .setIssuedAt(new Date(System.currentTimeMillis()))
              .setExpiration(new Date(System.currentTimeMillis() + expiration))
              .signWith(this.getSigninKey())
              .compact();
   }

   public Claims extractAllClaims(String jwtToken) {
      try {
        return Jwts.parserBuilder()
                .setSigningKey(this.getSigninKey()).build()
                .parseClaimsJws(jwtToken)
                .getBody();
      } catch (ExpiredJwtException | MalformedJwtException | SignatureException exception) {
         throw new ApiAuthException(exception.getMessage());
      }
   }

   private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
      final Claims claims = this.extractAllClaims(token);
      return claimsResolver.apply(claims);
   }

   private Date extractExpiration(String token) {
      return this.extractClaim(token, Claims::getExpiration);
   }

   @Override
   public boolean isTokenValid(String token, UserDetails userDetails) {
      final  String username = this.extractUsername(token);
      return (username.equals(userDetails.getUsername())) && !(this.isTokenExpired(token));
   }

   public boolean isTokenExpired(String token) {
      return this.extractExpiration(token).before(new Date());
   }

   @Override
   public String extractUsername(String token) {
      return this.extractClaim(token, Claims::getSubject);
   }

   private Key getSigninKey() {
      byte[] keyBytes = Decoders.BASE64.decode(secret);
      return Keys.hmacShaKeyFor(keyBytes);
   }

   public Map<String, Object> mapClaims(String claimKey, String claimValue) {
      return Map.of(claimKey, claimValue);
   }

}
