package com.developmentteam.brothersdeliveryapi.dto.request.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateRequest{
    String categoryName;
    String categoryDescription;
}
