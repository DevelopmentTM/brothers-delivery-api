package com.developmentteam.brothersdeliveryapi.controllers.catalog;

import java.util.List;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.CategoryCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.request.catalog.CategoryUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.CategoryCreateResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.CategoryResponse;
import com.developmentteam.brothersdeliveryapi.services.catalog.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorys")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryCreateResponse create(@RequestBody CategoryCreateRequest categoryCreateRequest){
        return categoryService.createCategory(categoryCreateRequest);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> allCategory(){
        return ResponseEntity.ok().body(categoryService.allCategory());
    }

    @PutMapping
    public ResponseEntity<CategoryResponse> updateCategory(@RequestBody CategoryUpdateRequest categoryUpdateRequest){
        return ResponseEntity.ok().body(categoryService.updateCategory(categoryUpdateRequest));
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
