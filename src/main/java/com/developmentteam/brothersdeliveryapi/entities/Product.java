package com.developmentteam.brothersdeliveryapi.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productPrice")
    private BigDecimal productPrice;

    @ManyToMany(mappedBy = "products")
    private List<Stores> stores;

    @ManyToMany(mappedBy = "products")
    private List<Category> category;

    @ManyToMany(mappedBy = "products")
    private List<OrderItens> orderItens;

    @ManyToMany(mappedBy = "products")
    private List<User> users;
}