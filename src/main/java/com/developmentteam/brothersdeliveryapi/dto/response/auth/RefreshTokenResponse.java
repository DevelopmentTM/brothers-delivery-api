package com.developmentteam.brothersdeliveryapi.dto.response.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.RefreshToken;

import java.io.Serializable;

public record RefreshTokenResponse(String jwt, String refreshToken) implements Serializable {
   public static RefreshTokenResponse toResponse(String jwt, String refreshToken) {
      return new RefreshTokenResponse(jwt, refreshToken);
   }
}
