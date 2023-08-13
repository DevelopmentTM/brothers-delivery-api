package com.developmentteam.brothersdeliveryapi.dto.application;

import java.io.Serializable;

public record ApiResponseMessage(String message) implements Serializable {
   public static ApiResponseMessage of(String message) {
      return new ApiResponseMessage(message);
   }
}
