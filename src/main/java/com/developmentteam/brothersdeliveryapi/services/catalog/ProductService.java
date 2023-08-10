package com.developmentteam.brothersdeliveryapi.services.catalog;

import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.repositories.catalog.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

}
