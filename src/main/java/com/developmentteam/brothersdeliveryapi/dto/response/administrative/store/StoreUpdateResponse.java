package com.developmentteam.brothersdeliveryapi.dto.response.administrative.store;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

import java.io.Serializable;
import java.time.LocalDateTime;

public record StoreUpdateResponse(

        String storeName,

        String storeDescription,

        LocalDateTime storeDeliveryStart,

        LocalDateTime storeDeliveryEnd

//        Segment storeSegment

) implements Serializable {

    public static StoreUpdateResponse toResponse(Store store) {

        return new StoreUpdateResponse(
                store.getStoreName(),
                store.getStoreDescription(),
                store.getStoreDeliveryStart(),
                store.getStoreDeliveryEnd()
//                  store.getStoreSegment()
        );
    }

}

