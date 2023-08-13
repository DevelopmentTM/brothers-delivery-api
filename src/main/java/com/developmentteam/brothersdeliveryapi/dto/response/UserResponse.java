package com.developmentteam.brothersdeliveryapi.dto.response;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;

import java.io.Serializable;

public record UserResponse(

        String userName,
        String userEmail,
        String userPhone

) implements Serializable {

   public static UserResponse toResponse(User user) {
      return new UserResponse(
              user.getUserName(),
              user.getUserEmail(),
              user.getUserPhone()
      );
   }

}
