package com.developmentteam.brothersdeliveryapi.dto.models;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

import java.io.Serializable;

public record StoreModel(
        Long id,
        String nome
)implements Serializable {
    public static StoreModel toResponse(Store store){
        return new StoreModel(store.getStoreId(),
                store.getStoreName());
    }
}
