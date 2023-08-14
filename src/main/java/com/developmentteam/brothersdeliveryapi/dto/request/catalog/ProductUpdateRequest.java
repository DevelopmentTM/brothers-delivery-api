package com.developmentteam.brothersdeliveryapi.dto.request.catalog;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductUpdateRequest(

        @NotBlank
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String description,

        @NotNull
        BigDecimal price
) {
}
