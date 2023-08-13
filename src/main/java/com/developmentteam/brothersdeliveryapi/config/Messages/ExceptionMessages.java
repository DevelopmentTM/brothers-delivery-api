package com.developmentteam.brothersdeliveryapi.config.Messages;

public enum ExceptionMessages {

   REFRESH_TOKEN_NOT_FOUND("auth.refresh-token.not-found"),
   REFRESH_TOKEN_EXPIRED("auth.refresh-token.expired"),
   RESET_CODE_INVALID("auth.reset-code.invalid"),
   RESET_CODE_EXPIRED("auth.reset-code.expired"),
   RESET_CODE_ALREADY_USED("auth.reset-code.already-used");

   final String prop;

   ExceptionMessages(String prop) {
      this.prop = prop;
   }

   public String prop() {
      return this.prop;
   }
}
