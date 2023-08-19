package com.developmentteam.brothersdeliveryapi.dto.response.auth;

import java.io.Serializable;

public record ForgotPasswordResponse(String message, String email) implements Serializable {

   public static ForgotPasswordResponse toResponse(String message, String email) {
      return new ForgotPasswordResponse(message, email);
   }

}
