package com.developmentteam.brothersdeliveryapi.controllers.auth;

import com.developmentteam.brothersdeliveryapi.dto.application.ApiResponse;
import com.developmentteam.brothersdeliveryapi.dto.application.ApiResponseMessage;
import com.developmentteam.brothersdeliveryapi.dto.request.auth.SignInRequest;
import com.developmentteam.brothersdeliveryapi.dto.request.auth.SignUpRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.SignInResponse;
import com.developmentteam.brothersdeliveryapi.services.auth.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "auth controller")
public class AuthController {

   private final AuthService authService;

   @PostMapping("/signIn")
   public ResponseEntity<ApiResponse<SignInResponse>> signIn(@RequestBody @Valid SignInRequest request) {
      SignInResponse response = this.authService.signIn(request);
      return ApiResponse.<SignInResponse>builder().status(HttpStatus.OK).response(response).build();
   }

   @PostMapping("/signUp")
   public ResponseEntity<ApiResponse<ApiResponseMessage>> signUn(@RequestBody @Valid SignUpRequest request) {
      ApiResponseMessage response = this.authService.signUn(request);
      return ApiResponse.<ApiResponseMessage>builder().status(HttpStatus.OK).response(response).build();
   }

}
