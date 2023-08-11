package com.developmentteam.brothersdeliveryapi.controllers.customers;

import com.developmentteam.brothersdeliveryapi.dto.request.UserRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.UserResponse;
import com.developmentteam.brothersdeliveryapi.services.auth.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

   @PostMapping("")
   public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest request) {
      UserResponse response = userService.createUser(request);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
   }

}
