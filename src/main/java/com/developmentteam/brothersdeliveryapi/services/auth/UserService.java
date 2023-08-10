package com.developmentteam.brothersdeliveryapi.services.auth;

import com.developmentteam.brothersdeliveryapi.dto.request.UserRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

   public UserResponse createUser(UserRequest request) {
      User user = User.builder()

              .build();

      return  UserResponse.toResponse("name", "email");
   }

}
