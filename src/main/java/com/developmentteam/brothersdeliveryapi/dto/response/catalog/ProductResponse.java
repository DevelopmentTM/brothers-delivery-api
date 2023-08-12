package com.developmentteam.brothersdeliveryapi.dto.response.catalog;

import java.io.Serializable;
import java.math.BigDecimal;

import com.developmentteam.brothersdeliveryapi.dto.models.StoreModel;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;

public record ProductResponse(

    String nome,
    String description,
    BigDecimal price,
    CategoryResponse CategoryModel,
    StoreModel storeModel

)implements Serializable {

    public static ProductResponse toResponse(Product product,StoreModel store, CategoryResponse category){
        return new ProductResponse(
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                category,
                store
        );
    }

}
