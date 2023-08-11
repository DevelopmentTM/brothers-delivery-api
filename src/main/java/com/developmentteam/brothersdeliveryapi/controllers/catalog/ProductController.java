package com.developmentteam.brothersdeliveryapi.controllers.catalog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developmentteam.brothersdeliveryapi.dto.request.ProductCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.ProductCreateResponse;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;
import com.developmentteam.brothersdeliveryapi.services.catalog.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<ProductCreateResponse> create(@RequestBody @Valid ProductCreateRequest productCreateRequest){
        ProductCreateResponse productCreateResponse = productService.createProduct(productCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreateResponse);
    }

}
