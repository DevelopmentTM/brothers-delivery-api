package com.developmentteam.brothersdeliveryapi.config.exceptions.custom;

public class ApiAuthException extends RuntimeException {
   public ApiAuthException() {
      super();
   }

   public ApiAuthException(String message) {
      super(message);
   }

   public ApiAuthException(String message, Throwable cause) {
      super(message, cause);
   }
}
