package com.developmentteam.brothersdeliveryapi.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record UserRequest(

        @NotBlank()
        String userName,

        @NotBlank
        String userEmail,

        @NotBlank
        String userPassword,

        @NotBlank
        String userPhone,

        @NotBlank
        String userCpf

) implements Serializable { }
