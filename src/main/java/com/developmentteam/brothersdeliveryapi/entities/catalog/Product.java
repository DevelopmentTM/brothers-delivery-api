package com.developmentteam.brothersdeliveryapi.entities.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;
import com.developmentteam.brothersdeliveryapi.entities.orders.OrderItems;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product", schema = "public")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = true, length = 50 )
    private String productName;

    @Column(name = "product_description", nullable = true, length = 255)
    private String productDescription;

    @Column(name = "product_price", nullable = true)
    private BigDecimal productPrice;

    @ManyToMany(mappedBy = "storeProducts", fetch = FetchType.EAGER)
    private List<Store> productStores;

    @ManyToMany(mappedBy = "categoryProducts", fetch = FetchType.EAGER)
    private List<Category> productCategories;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderItems> orderItems;

}