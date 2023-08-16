package com.developmentteam.brothersdeliveryapi.config.exceptions.custom;

import org.springframework.security.core.AuthenticationException;

public class ApiAuthException extends AuthenticationException {

   public ApiAuthException(String msg, Throwable cause) {
      super(msg, cause);
   }

   public ApiAuthException(String msg) {
      super(msg);
   }
}
