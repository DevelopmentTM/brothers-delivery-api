package com.developmentteam.brothersdeliveryapi.services.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.ProductUpdateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductCreateResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductUpdateResponse;
import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.dto.request.catalog.ProductCreateRequest;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductAllResponse;
import com.developmentteam.brothersdeliveryapi.dto.response.catalog.ProductResponse;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Category;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;
import com.developmentteam.brothersdeliveryapi.repositories.administrative.StoreRepository;
import com.developmentteam.brothersdeliveryapi.repositories.catalog.CategoryRepository;
import com.developmentteam.brothersdeliveryapi.repositories.catalog.ProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final StoreRepository storeRepository;

    @Transactional
    public ProductCreateResponse createProduct(ProductCreateRequest productRequest){

        Optional<Category> categoryFind = categoryRepository.findById(productRequest.categoryId());
        Optional<Store> storeFind = storeRepository.findById(productRequest.storeId());

        Product product = Product.builder()
            .productName(productRequest.productName())
            .productDescription(productRequest.productDescription())
            .productPrice(productRequest.productPrice())
        .build();

        Product productSaved = productRepository.save(product);

        categoryFind.get().getCategoryProducts().add(product);
        storeFind.get().getStoreProducts().add(product);

        return ProductCreateResponse.toResponse(productSaved);
    }

    public List<ProductAllResponse> allProduct(){
        return productRepository.findAll().stream().map(ProductAllResponse::toResponse).toList();
    }

    public ProductResponse getProduct(Long id){

        Optional<Product> productFind = productRepository.findById(id);

        System.out.println(productFind.get().toString());

        return ProductResponse.toResponse(productFind.get(), null, null);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public ProductUpdateResponse updateProduct(ProductUpdateRequest productUpdateRequest){

        Product product = Product.builder()
                .productId(productUpdateRequest.id())
                .productName(productUpdateRequest.name())
                .productDescription(productUpdateRequest.description())
                .build();
        productRepository.save(product);

        return ProductUpdateResponse.toResponse(product);
    }

}
