package com.developmentteam.brothersdeliveryapi.dto.response.catalog;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.ProductUpdateRequest;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;

public record ProductUpdateResponse(
        Long id,

        String name,
        String description
) {

    public static ProductUpdateResponse toResponse(Product product){
        return new ProductUpdateResponse(
                product.getProductId(),
                product.getProductName(),
                product.getProductDescription()
        );
    }

}
