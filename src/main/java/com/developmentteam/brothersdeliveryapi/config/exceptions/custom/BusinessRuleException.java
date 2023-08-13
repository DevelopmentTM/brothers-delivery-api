package com.developmentteam.brothersdeliveryapi.config.exceptions.custom;

public class BusinessRuleException extends RuntimeException {
   public BusinessRuleException() {
   }

   public BusinessRuleException(String message) {
      super(message);
   }

   public BusinessRuleException(String message, Throwable cause) {
      super(message, cause);
   }
}
