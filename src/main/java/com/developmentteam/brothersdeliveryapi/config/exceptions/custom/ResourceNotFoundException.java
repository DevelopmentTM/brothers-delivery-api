package com.developmentteam.brothersdeliveryapi.config.exceptions.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
   public ResourceNotFoundException() {
   }

   public ResourceNotFoundException(String message) {
      super(message);
   }

   public ResourceNotFoundException(String message, Throwable cause) {
      super(message, cause);
   }

   public static void throwWithMsg(String message) {
      throw  new ResourceNotFoundException(message);
   }

   public static Supplier<RuntimeException> msg(String message) {
      return () -> new ResourceNotFoundException(message);
   }
}
