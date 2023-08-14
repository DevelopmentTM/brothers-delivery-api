package com.developmentteam.brothersdeliveryapi.dto.request.catalog;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCreateRequest(

    @NotBlank
    String productName,

    @NotBlank
    String productDescription,
    
    @NotNull
    BigDecimal productPrice,

    @NotNull
    Long categoryId,

    @NotNull
    Long storeId

)implements Serializable {
    
}
