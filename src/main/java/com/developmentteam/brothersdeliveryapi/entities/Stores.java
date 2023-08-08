package com.developmentteam.brothersdeliveryapi.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Store")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "storeDescription")
    private String storeDescription;

    @ManyToOne
    @JoinColumn(name = "segmentId")
    private Segment segment;

    @Column(name = "assessment")
    private BigDecimal assessment;

    @Column(name = "startDelivery")
    private LocalDateTime startDelivery;

    @Column(name = "endDelivery")
    private LocalDateTime endDelivery;

    @ManyToMany
    @JoinTable(name = "store_product", joinColumns = @JoinColumn(name = "storeId"), inverseJoinColumns = @JoinColumn(name = "productId"))
    private List<Product> productId;

    @ManyToOne
    @JoinColumn(name = "segmentId")
    private Segment segments;

    @OneToMany(mappedBy = "stores")
    private List<Order> order;

}
