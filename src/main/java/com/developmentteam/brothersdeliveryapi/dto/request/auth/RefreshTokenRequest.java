package com.developmentteam.brothersdeliveryapi.dto.request.auth;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record RefreshTokenRequest(

        @NotBlank
        String refreshToken

) implements Serializable { }
