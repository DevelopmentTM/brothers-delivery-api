package com.developmentteam.brothersdeliveryapi.dto.request.administrative;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record StoreRequest(

        @NotBlank()
        String storeName,

        @NotBlank()
        String storeDescription,

        @NotNull()
        LocalDateTime storeDeliveryStart,

        @NotNull()
        LocalDateTime storeDeliveryEnd,

        @NotNull()
        Long storeSegmentId
) {
}
