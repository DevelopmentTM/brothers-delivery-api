package com.developmentteam.brothersdeliveryapi.dto.response.catalog;

public record ProductCreateResponse(

    Long id,
    String nome

) {
    public static ProductCreateResponse toResponse(Long id, String nome){
        return new ProductCreateResponse(id, nome);
    }
}
