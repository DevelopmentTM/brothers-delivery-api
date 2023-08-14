package com.developmentteam.brothersdeliveryapi.dto.models;

import java.io.Serializable;

public record CategoryModel(

    String name,
    String description

)implements Serializable {
    
}
