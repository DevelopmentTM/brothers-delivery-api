package com.developmentteam.brothersdeliveryapi.controllers.catalog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developmentteam.brothersdeliveryapi.services.catalog.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorys")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;

}
