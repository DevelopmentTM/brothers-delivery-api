package com.developmentteam.brothersdeliveryapi.dto.request.catalog;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record ProductCreateRequest(

    @NotBlank
    String productName,

    @NotBlank
    String productDescription,
    
    @NotBlank
    BigDecimal productPrice,

    @NotBlank
    Long categoryId,

    @NotBlank
    Long storeId

)implements Serializable {
    
}
