package com.developmentteam.brothersdeliveryapi.services.auth;

import com.developmentteam.brothersdeliveryapi.dto.application.ApiResponseMessage;
import com.developmentteam.brothersdeliveryapi.dto.request.auth.SignInRequest;
import com.developmentteam.brothersdeliveryapi.dto.request.auth.SignUpRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.auth.SignInResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {

   public SignInResponse signIn(SignInRequest request) {

      return SignInResponse.toResponse("wuedviiwveivdfuwyevfdujvweufvwuiebf");
   }

   public ApiResponseMessage signUn(SignUpRequest request) {

      return ApiResponseMessage.of("Cadastro realizado com sucesso!");
   }
}
