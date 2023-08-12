package com.developmentteam.brothersdeliveryapi.dto.models;

import java.io.Serializable;

public record StoreModel(
    String nome
)implements Serializable {
    public static StoreModel toResponse(String nome){
        return new StoreModel(nome);
    }
}
