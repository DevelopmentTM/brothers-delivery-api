package com.developmentteam.brothersdeliveryapi.dto.application;

import java.io.Serializable;

public record ApiMessage(String message) implements Serializable {
   public static ApiMessage of(String message) {
      return new ApiMessage(message);
   }
}
