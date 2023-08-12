package com.developmentteam.brothersdeliveryapi.controllers.catalog;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.CategoryCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.CategoryCreateResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.CategoryResponse;
import com.developmentteam.brothersdeliveryapi.services.catalog.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorys")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<CategoryCreateResponse> create(@RequestBody CategoryCreateRequest categoryCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryCreateRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> allCategory(){
        return ResponseEntity.ok().body(categoryService.allCategory());
    }
}
