package com.developmentteam.brothersdeliveryapi.services.auth;

import com.developmentteam.brothersdeliveryapi.config.exceptions.custom.ResourceNotFoundException;
import com.developmentteam.brothersdeliveryapi.dto.request.UserRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.UserResponse;
import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import com.developmentteam.brothersdeliveryapi.repositories.auth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

   private final PasswordEncoder passwordEncoder;
   private final UserRepository userRepository;

   public UserResponse createUser(UserRequest request) {
      User user = User.builder()
              .userFirstName(request.userName())
              .userEmail(request.userEmail())
              .userPassword(request.userPassword())
              .userCpf(request.userCpf())
              .userPhone(request.userPhone())
              .build();

      User userSaved = userRepository.save(user);

      return UserResponse.toResponse(userSaved);
   }

   public void changeThePassword(User user, String newPassword) {
      var newPasswordEncode = passwordEncoder.encode(newPassword);
      user.setUserPassword(newPasswordEncode);
      userRepository.save(user);
   }
}
