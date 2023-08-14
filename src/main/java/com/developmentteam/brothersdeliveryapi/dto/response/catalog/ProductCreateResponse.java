package com.developmentteam.brothersdeliveryapi.dto.response.catalog;

import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;

import java.io.Serializable;
import java.math.BigDecimal;

public record ProductCreateResponse(
        Long id,

        String name,

        String description,

        BigDecimal price
)implements Serializable {
    public static ProductCreateResponse toResponse(Product product){
        return new ProductCreateResponse(
                product.getProductId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice()
        );
    }
}
