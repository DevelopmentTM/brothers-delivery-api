package com.developmentteam.brothersdeliveryapi.dto.response.administrative;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

import java.io.Serializable;
import java.time.LocalDateTime;

public record StoreAllResponse(

        Long storeId,

        String storeName,

        String storeDescription,

        Integer storeAssessment,

        LocalDateTime storeDeliveryStart,

        LocalDateTime storeDeliveryEnd,

        Segment storeSegment) implements Serializable {

        public static StoreAllResponse toResponse(Store store) {

            return new StoreAllResponse(
                  store.getStoreId(),
                  store.getStoreName(),
                  store.getStoreDescription(),
                  store.getStoreAssessment(),
                  store.getStoreDeliveryStart(),
                  store.getStoreDeliveryEnd(),
                  store.getStoreSegment()
                );
        }
}
