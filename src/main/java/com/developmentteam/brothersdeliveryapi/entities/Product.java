package com.developmentteam.brothersdeliveryapi.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Product", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productPrice")
    private BigDecimal productPrice;

    @ManyToMany(mappedBy = "storeProducts", fetch = FetchType.LAZY)
    private List<Store> productStores;

    @ManyToMany(mappedBy = "categoryProducts", fetch = FetchType.LAZY)
    private List<Category> productCategories;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderItems> orderItems;

}