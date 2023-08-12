package com.developmentteam.brothersdeliveryapi.services.catalog;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.CategoryCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.CategoryCreateResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.CategoryResponse;
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

    public List<CategoryResponse> allCategory(){
        
        List<Category> categorysFind = categoryRepository.findAll();

        return categorysFind.stream().map(categorys -> {
            CategoryResponse dto = new CategoryResponse(
                    categorys.getCategoryName(), categorys.getCategoryDescription()
                );
                return dto;

        }).collect(Collectors.toList());
    }

    public CategoryResponse getCategory(Long id){
        Optional<Category> category = categoryRepository.findById(id);

        return CategoryResponse.toResponse(category.get());
    }


}
