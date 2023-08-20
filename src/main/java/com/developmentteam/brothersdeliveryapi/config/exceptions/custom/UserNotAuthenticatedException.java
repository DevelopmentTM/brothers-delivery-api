package com.developmentteam.brothersdeliveryapi.config.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UserNotAuthenticatedException extends RuntimeException {
   public UserNotAuthenticatedException() {
   }

   public UserNotAuthenticatedException(String message) {
      super(message);
   }

   public UserNotAuthenticatedException(String message, Throwable cause) {
      super(message, cause);
   }
}
