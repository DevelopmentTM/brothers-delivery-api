package com.developmentteam.brothersdeliveryapi.controllers.catalog;

import java.util.List;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.ProductUpdateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductCreateResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductUpdateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.ProductCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductAllResponse;
import com.developmentteam.brothersdeliveryapi.services.catalog.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid ProductCreateRequest productCreateRequest){
        productService.createProduct(productCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductAllResponse>> allProduct(){
        return ResponseEntity.ok().body(productService.allProduct());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProduct(id));
    }

    @PutMapping
    public ResponseEntity<ProductUpdateResponse> updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest){
        return ResponseEntity.ok().body(productService.updateProduct(productUpdateRequest));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
