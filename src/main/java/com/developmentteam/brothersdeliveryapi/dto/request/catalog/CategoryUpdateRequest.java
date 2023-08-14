package com.developmentteam.brothersdeliveryapi.dto.request.catalog;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record CategoryUpdateRequest(

        @NotBlank
        Long categoryId,
        @NotBlank
        String categoryName,
        @NotBlank
        String categoryDescription
)implements Serializable {
}
