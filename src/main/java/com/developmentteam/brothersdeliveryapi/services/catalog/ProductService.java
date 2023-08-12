package com.developmentteam.brothersdeliveryapi.services.catalog;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.ProductCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductAllResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductCreateResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductResponse;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Category;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;
import com.developmentteam.brothersdeliveryapi.repositories.administrative.StoreRepository;
import com.developmentteam.brothersdeliveryapi.repositories.catalog.CategoryRepository;
import com.developmentteam.brothersdeliveryapi.repositories.catalog.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final StoreRepository storeRepository;

    public ProductCreateResponse createProduct(ProductCreateRequest productRequest){

        Optional<Category> categoryFind = categoryRepository.findById(productRequest.categoryId());
        Optional<Store> storeFind = storeRepository.findById(productRequest.storeId());

        Product product = Product.builder()
            .productName(productRequest.productName())
            .productDescription(productRequest.productDescription())
            .productPrice(productRequest.productPrice())
        .build();

        product.getProductStores().add(storeFind.get());

        product.getProductCategories().add(categoryFind.get());

        Product productSaved = productRepository.save(product);

        return ProductCreateResponse.toResponse(productSaved.getProductId() ,productSaved.getProductName());
        
    }

    public List<ProductAllResponse> allProduct(){
        return productRepository.findAll().stream().map(ProductAllResponse::toResponse).toList();
    }

    public ProductResponse getProduct(Long id){

        Optional<Product> productFind = productRepository.findById(id);

        

        return null;
    }

}
