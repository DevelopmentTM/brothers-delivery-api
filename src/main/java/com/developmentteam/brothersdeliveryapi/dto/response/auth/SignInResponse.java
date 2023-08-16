package com.developmentteam.brothersdeliveryapi.dto.response.auth;

import java.io.Serializable;

public record SignInResponse(

        String jwt

) implements Serializable {

   public static SignInResponse toResponse(String jwt) {
      return new SignInResponse(jwt);
   }

}
