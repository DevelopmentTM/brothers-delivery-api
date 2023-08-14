package com.developmentteam.brothersdeliveryapi.services.catalog;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.CategoryCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.request.catalog.CategoryUpdateRequest;
import org.springframework.stereotype.Service;

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
            .categoryName(categoryCreateRequest.categoryName())
            .categoryDescription(categoryCreateRequest.categoryDescription())
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
