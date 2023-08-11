package com.developmentteam.brothersdeliveryapi.dto.response;

import java.io.Serializable;

public record UserResponse(

        String userName,
        String userEmail,
        String userPhone

) implements Serializable {

   public static UserResponse toResponse(String name, String email, String password) {
      return new UserResponse(
              name,
              email,
              password
      );
   }

}
