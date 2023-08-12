package com.developmentteam.brothersdeliveryapi.dto.request.catalog;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequest(

    @NotBlank
    String nome,

    @NotBlank
    String description

) implements Serializable {
    
}
