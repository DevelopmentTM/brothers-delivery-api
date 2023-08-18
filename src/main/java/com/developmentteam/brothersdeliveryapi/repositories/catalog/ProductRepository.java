package com.developmentteam.brothersdeliveryapi.repositories.catalog;

import com.developmentteam.brothersdeliveryapi.entities.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
