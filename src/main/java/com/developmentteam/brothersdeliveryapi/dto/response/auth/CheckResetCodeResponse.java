package com.developmentteam.brothersdeliveryapi.dto.response.auth;

import java.io.Serializable;

public record CheckResetCodeResponse(String resetToken) implements Serializable {

   public static CheckResetCodeResponse toResponse(String resetToken) {
      return new CheckResetCodeResponse(resetToken);
   }

}