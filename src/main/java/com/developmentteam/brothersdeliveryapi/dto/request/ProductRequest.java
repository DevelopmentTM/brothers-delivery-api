package com.developmentteam.brothersdeliveryapi.dto.request;

import java.io.Serializable;

public record ProductRequest(
    String productName,
    String productDescription,
    String productPrice
)implements Serializable {
    
}
