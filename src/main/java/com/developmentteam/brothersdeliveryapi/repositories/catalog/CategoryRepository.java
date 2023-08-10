package com.developmentteam.brothersdeliveryapi.repositories.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developmentteam.brothersdeliveryapi.entities.catalog.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
