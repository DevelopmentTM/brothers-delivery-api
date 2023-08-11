package com.developmentteam.brothersdeliveryapi.services.catalog;

import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.dto.request.CategoryCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.CategoryCreateResponse;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Category;
import com.developmentteam.brothersdeliveryapi.repositories.catalog.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryCreateResponse createCategory(CategoryCreateRequest categoryCreateRequest){

        Category category = Category.builder()
            .categoryName(categoryCreateRequest.nome())
            .categoryDescription(categoryCreateRequest.description())
        .build();

        Category categorySaved = categoryRepository.save(category);

        return CategoryCreateResponse.toResponse(categorySaved.getCategoryId(), categorySaved.getCategoryName());
    }

}
