package com.developmentteam.brothersdeliveryapi.dto.request.auth;

import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsEmailValid;
import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsPasswordStrong;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record SignInRequest(

        @NotBlank
        @IsEmailValid
        String userEmail,
        @NotBlank
        @IsPasswordStrong
        String userPassword

) implements Serializable { }
