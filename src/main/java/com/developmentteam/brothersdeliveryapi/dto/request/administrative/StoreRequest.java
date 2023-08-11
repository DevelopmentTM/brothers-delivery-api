package com.developmentteam.brothersdeliveryapi.dto.request.administrative;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record StoreRequest(

        @NotNull()
        @NotBlank()
        String storeName,

        @NotNull()
        @NotBlank()
        String storeDescription,

        @NotNull()
        @NotBlank()
        LocalDateTime storeDeliveryStar,

        @NotNull()
        @NotBlank()
        LocalDateTime storeDeliveryEnd) {
}
