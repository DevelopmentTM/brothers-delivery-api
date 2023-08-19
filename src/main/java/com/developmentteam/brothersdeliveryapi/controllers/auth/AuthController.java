package com.developmentteam.brothersdeliveryapi.controllers.auth;

import com.developmentteam.brothersdeliveryapi.dto.application.ApiResponse;
import com.developmentteam.brothersdeliveryapi.dto.application.ApiResponseMessage;
import com.developmentteam.brothersdeliveryapi.dto.request.auth.*;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.CheckResetCodeResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.ForgotPasswordResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.SignInResponse;
import com.developmentteam.brothersdeliveryapi.services.auth.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

   @GetMapping("/confirm-registration")
   public ResponseEntity<ApiResponse<ApiResponseMessage>> verificationEmail(@RequestParam("token") String token) {
      ApiResponseMessage response = this.authService.confirmVerification(token);
      return ApiResponse.<ApiResponseMessage>builder().status(HttpStatus.OK).response(response).build();
   }

   @PostMapping("/forgot-password")
   public ResponseEntity<ApiResponse<ForgotPasswordResponse>> forgotPassword(@RequestBody @Valid ForgotPasswordRequest request) {
      ForgotPasswordResponse response = this.authService.forgotPassword(request);
      return ApiResponse.<ForgotPasswordResponse>builder().status(HttpStatus.OK).response(response).build();
   }

   @PostMapping("/check-code")
   public ResponseEntity<ApiResponse<CheckResetCodeResponse>> checkResetCode(@RequestBody @Valid CheckResetCodeRequest request) {
      CheckResetCodeResponse response = this.authService.checkResetCode(request);
      return ApiResponse.<CheckResetCodeResponse>builder().status(HttpStatus.OK).response(response).build();
   }

   @PatchMapping("/reset-password")
   public ResponseEntity<ApiResponse<ApiResponseMessage>> resetPassword(@RequestBody ResetPasswordRequest request) {
      ApiResponseMessage response = this.authService.resetPassword(request);
      return ApiResponse.<ApiResponseMessage>builder().status(HttpStatus.OK).response(response).build();
   }

//   @PostMapping("/refresh")
//   public ResponseEntity<ApiResponse<>>

}
