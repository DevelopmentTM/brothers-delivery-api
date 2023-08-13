package com.developmentteam.brothersdeliveryapi.config.messages;

public enum ValidationMessages {
   VALID("");

   final String prop;

   ValidationMessages(String prop) {
      this.prop = prop;
   }

   public String prop() {
      return prop;
   }
}
