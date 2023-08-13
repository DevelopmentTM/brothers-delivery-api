package com.developmentteam.brothersdeliveryapi.config.Messages;

public enum ApplicationMessages {

   TESTE("teste.message");

   final String keyValue;

   ApplicationMessages(String keyMessageValue) {
      this.keyValue = keyMessageValue;
   }

   public String getKeyValue() {
      return keyValue;
   }
}