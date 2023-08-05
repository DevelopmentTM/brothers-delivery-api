package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Product_Store")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductStore {
    
    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "productId")
    private Long productId;
}
