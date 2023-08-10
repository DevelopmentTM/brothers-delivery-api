package com.developmentteam.brothersdeliveryapi.entities.catalog;

import java.math.BigDecimal;
import java.util.List;

import com.developmentteam.brothersdeliveryapi.entities.OrderItems;
import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName", nullable = true, length = 50 )
    private String productName;

    @Column(name = "productDescription", nullable = true, length = 255)
    private String productDescription;

    @Column(name = "productPrice", nullable = true)
    private BigDecimal productPrice;

    @ManyToMany(mappedBy = "storeProducts", fetch = FetchType.LAZY)
    private List<Store> productStores;

    @ManyToMany(mappedBy = "categoryProducts", fetch = FetchType.LAZY)
    private List<Category> productCategories;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderItems> orderItems;

}