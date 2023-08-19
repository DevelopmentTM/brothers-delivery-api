package com.developmentteam.brothersdeliveryapi.dto.request.auth;

import com.developmentteam.brothersdeliveryapi.dto.validation.annotations.IsEmailValid;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record ForgotPasswordRequest(

        @NotBlank
//        @IsEmailValid
        String email

) implements Serializable { }
