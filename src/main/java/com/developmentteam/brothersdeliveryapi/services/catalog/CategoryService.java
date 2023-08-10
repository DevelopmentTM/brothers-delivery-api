package com.developmentteam.brothersdeliveryapi.services.catalog;

import org.springframework.stereotype.Service;

import com.developmentteam.brothersdeliveryapi.repositories.catalog.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;

}
