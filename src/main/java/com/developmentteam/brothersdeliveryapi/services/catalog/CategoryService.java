package com.developmentteam.brothersdeliveryapi.services.catalog;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.CategoryCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.request.catalog.CategoryUpdateRequest;
import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.dto.response.catalog.CategoryResponse;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Category;
import com.developmentteam.brothersdeliveryapi.repositories.catalog.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

    public CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest){

        Category category = Category.builder()
            .categoryName(categoryCreateRequest.getCategoryName())
            .categoryDescription(categoryCreateRequest.getCategoryDescription())
        .build();

        Category categorySaved = categoryRepository.save(category);

        return CategoryResponse.toResponse(categorySaved);
    }

    public List<CategoryResponse> allCategory(){
        
        List<Category> categoriesFind = categoryRepository.findAll();

        return categoriesFind.stream().map(categories -> {
            CategoryResponse dto = new CategoryResponse(
                    categories.getCategoryId(),
                    categories.getCategoryName(),
                    categories.getCategoryDescription()
                );
                return dto;

        }).collect(Collectors.toList());
    }

    public CategoryResponse getCategory(Long id){
        Optional<Category> category = categoryRepository.findById(id);

        return CategoryResponse.toResponse(category.get());
    }

    public CategoryResponse updateCategory(CategoryUpdateRequest categoryUpdateRequest){
        Category category = Category.builder()
                .categoryId(categoryUpdateRequest.categoryId())
                .categoryName(categoryUpdateRequest.categoryName())
                .categoryDescription(categoryUpdateRequest.categoryDescription())
                .build();

        categoryRepository.save(category);

        return CategoryResponse.toResponse(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
