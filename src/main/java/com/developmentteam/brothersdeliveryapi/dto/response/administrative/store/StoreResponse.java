package com.developmentteam.brothersdeliveryapi.dto.response.administrative.store;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

import java.io.Serializable;
import java.time.LocalDateTime;

public record StoreResponse(

        String storeName,

        String storeDescription,

        LocalDateTime storeDeliveryStart,

        LocalDateTime storeDeliveryEnd,

        String storeSegmentName) implements Serializable {

    public static StoreResponse toResponse(Store store) {

        return new StoreResponse(
                store.getStoreName(),
                store.getStoreDescription(),
                store.getStoreDeliveryStart(),
                store.getStoreDeliveryEnd(),
                store.getStoreSegment().getSegmentName()
        );
    }

}
