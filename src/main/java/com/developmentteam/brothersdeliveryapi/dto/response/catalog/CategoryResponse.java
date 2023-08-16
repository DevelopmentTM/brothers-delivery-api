package com.developmentteam.brothersdeliveryapi.dto.response.catalog;

import java.io.Serializable;

import com.developmentteam.brothersdeliveryapi.entities.catalog.Category;

public record CategoryResponse(

        Long id,

        String nome,
        String description

) implements Serializable {
    public static CategoryResponse toResponse(Category category){
        return new CategoryResponse(
                category.getCategoryId(),
            category.getCategoryName(),
            category.getCategoryDescription()
        );
    }    
}
