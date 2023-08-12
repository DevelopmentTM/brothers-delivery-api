package com.developmentteam.brothersdeliveryapi.dto.response.administrative.store;

import java.io.Serializable;
import java.time.LocalDateTime;

public record StoreResponse(

        String storeName,

        String storeDescription,

        LocalDateTime storeDeliveryStart,

        LocalDateTime storeDeliveryEnd) implements Serializable {

    public static StoreResponse toResponse(
            String storeName,
            String storeDescription,
            LocalDateTime storeDeliveryStart,
            LocalDateTime storeDeliveryEnd) {

        return new StoreResponse(
                storeName,
                storeDescription,
                storeDeliveryStart,
                storeDeliveryEnd
        );
    }

}
