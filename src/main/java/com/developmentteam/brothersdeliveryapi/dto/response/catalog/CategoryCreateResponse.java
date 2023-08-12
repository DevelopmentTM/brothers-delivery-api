package com.developmentteam.brothersdeliveryapi.dto.response.catalog;

import java.io.Serializable;

public record CategoryCreateResponse(

    Long id,
    String nome

) implements Serializable {


    public static CategoryCreateResponse toResponse(Long id, String nome){
        return new CategoryCreateResponse(id, nome);
    }

}
