package com.developmentteam.brothersdeliveryapi.dto.response.administrative.store;

import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;

import java.io.Serializable;
import java.math.BigDecimal;

public record StoreProductsResponse(

        Long productId,
        String productName,
        String productDescription,
        BigDecimal productPrice) implements Serializable {

    public static StoreProductsResponse toResponse(Product product) {

        return new StoreProductsResponse(
                product.getProductId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice()
        );
    }
}
