package com.developmentteam.brothersdeliveryapi.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

public record CheckResetCodeRequest(

        @NotBlank()
        String email,
        @NotNull()
        @Size(min = 6, max = 6)
        Integer resetCode

) implements Serializable { }