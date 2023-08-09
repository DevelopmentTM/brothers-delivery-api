package com.developmentteam.brothersdeliveryapi.entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Category", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "categoryName")
    @NotNull
    private String categoryName;

    @Column(name = "categoryDescription")
    private String categoryDescription;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "categoryId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> categoryProducts;
}
