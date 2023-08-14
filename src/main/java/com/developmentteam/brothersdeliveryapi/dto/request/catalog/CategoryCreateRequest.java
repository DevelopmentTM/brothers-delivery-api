package com.developmentteam.brothersdeliveryapi.dto.request.catalog;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreateRequest(

        @NotBlank()
        String categoryName,
        @NotBlank()
        String categoryDescription
) {
}
