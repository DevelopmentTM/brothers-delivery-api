package com.developmentteam.brothersdeliveryapi.dto.models;

import java.io.Serializable;

public record CategoryModel(

        Long id,
        String name,
        String description

)implements Serializable {
    
}
