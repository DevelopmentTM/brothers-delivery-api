package com.developmentteam.brothersdeliveryapi.entities.administrative;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.developmentteam.brothersdeliveryapi.entities.auth.User;
import com.developmentteam.brothersdeliveryapi.entities.catalog.Product;
import com.developmentteam.brothersdeliveryapi.entities.orders.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "store", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Store {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "storeName", nullable = true, length = 50)
    private String storeName;

    @Column(name = "storeDescription", length = 255)
    private String storeDescription;

    @Column(name = "assessment")
    private BigDecimal assessment;

    @Column(name = "storeDeliveryStar", nullable = true)
    private LocalDateTime storeDeliveryStart;

    @Column(name = "storeDeliveryEnd", nullable = true)
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
