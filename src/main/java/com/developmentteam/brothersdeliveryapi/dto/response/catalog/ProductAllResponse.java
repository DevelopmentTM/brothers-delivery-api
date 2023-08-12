package com.developmentteam.brothersdeliveryapi.dto.response.catalog;

import java.io.Serializable;
import java.math.BigDecimal;

import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;

public record ProductAllResponse(
    Long id,
    String name,
    String description,
    BigDecimal price
)implements Serializable {
    
    public static ProductAllResponse toResponse(Product product){
        return new ProductAllResponse(
            product.getProductId(),
            product.getProductName(),
            product.getProductDescription(),
            product.getProductPrice()
        );
    }
}
