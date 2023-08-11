package com.developmentteam.brothersdeliveryapi.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequest(

    @NotBlank
    String nome,

    @NotBlank
    String description

) implements Serializable {
    
}
