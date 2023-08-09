package com.developmentteam.brothersdeliveryapi.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Store {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "storeName")
    @NotNull
    private String storeName;

    @Column(name = "storeDescription")
    private String storeDescription;

    @Column(name = "assessment")
    private BigDecimal assessment;

    @Column(name = "storeDeliveryStar")
    @NotNull
    private LocalDateTime storeDeliveryStar;

    @Column(name = "storeDeliveryEnd")
    @NotNull
    private LocalDateTime storeDeliveryEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "segmentId", referencedColumnName = "segmentId", nullable = false)
    private Segment storeSegment;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "store_products",
            joinColumns = @JoinColumn(name = "storeId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> storeProducts;

    @OneToMany(mappedBy = "orderStore", fetch = FetchType.LAZY)
    private List<Order> storeOrders;

    @ManyToMany(mappedBy = "userStores", fetch = FetchType.LAZY)
    private List<User> storeUser;

}
