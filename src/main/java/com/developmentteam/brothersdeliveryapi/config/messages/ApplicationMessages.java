package com.developmentteam.brothersdeliveryapi.config.messages;

public enum ApplicationMessages {

   TESTE("teste.message");

   final String prop;

   ApplicationMessages(String prop) {
      this.prop = prop;
   }

   public String prop() {
      return prop;
   }
}