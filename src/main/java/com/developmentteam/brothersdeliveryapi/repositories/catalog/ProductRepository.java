package com.developmentteam.brothersdeliveryapi.repositories.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
