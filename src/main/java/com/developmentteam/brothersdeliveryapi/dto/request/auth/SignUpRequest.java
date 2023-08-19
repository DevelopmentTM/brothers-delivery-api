package com.developmentteam.brothersdeliveryapi.dto.request.auth;

import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsEmailValid;
import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsPasswordStrong;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public record SignUpRequest(

        @NotBlank
        String userFirstName,
        @NotBlank
        String userLastName,
        @NotBlank
//        @IsPasswordStrong(message = "teste")
        String userPassword,
        @NotBlank
//        @IsEmailValid(message = "teste")
        String userEmail,
        @NotBlank
        String userCpf,
        @NotBlank
        String userPhone


) implements Serializable { }
