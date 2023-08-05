package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ProductCategory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategory {

    @Column(name = "productId")
    private Long productId;

    @Column(name = "categoryId")
    private Long categoryId;
    
}
