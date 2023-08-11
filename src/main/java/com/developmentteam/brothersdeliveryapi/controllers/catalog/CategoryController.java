package com.developmentteam.brothersdeliveryapi.controllers.catalog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developmentteam.brothersdeliveryapi.dto.request.CategoryCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.CategoryCreateResponse;
import com.developmentteam.brothersdeliveryapi.services.catalog.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorys")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;

    public ResponseEntity<CategoryCreateResponse> create(@RequestBody CategoryCreateRequest categoryCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryCreateRequest));
    }

}
