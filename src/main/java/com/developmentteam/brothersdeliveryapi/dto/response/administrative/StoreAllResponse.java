package com.developmentteam.brothersdeliveryapi.dto.response.administrative;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record StoreAllResponse(

        Long storeId,

        String storeName,

        String storeDescription,

        LocalDateTime storeDeliveryStart,

        LocalDateTime storeDeliveryEnd,

        BigDecimal assessment) implements Serializable {

        public static StoreAllResponse toResponse(Store store) {

            return new StoreAllResponse(
                  store.getStoreId(),
                  store.getStoreName(),
                  store.getStoreDescription(),
                  store.getStoreDeliveryStart(),
                  store.getStoreDeliveryEnd(),
                  store.getAssessment()
                );
        }
}
