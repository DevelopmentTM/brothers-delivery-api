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
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "store_name", nullable = true, length = 50)
    private String storeName;

    @Column(name = "store_description", length = 255)
    private String storeDescription;

    @Column(name = "store_assessment")
    private Integer storeAssessment;

    @Column(name = "store_delivery_start", nullable = true)
    private LocalDateTime storeDeliveryStart;

    @Column(name = "store_delivery_end", nullable = true)
    private LocalDateTime storeDeliveryEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "segment_id", referencedColumnName = "segment_id", nullable = true)
    public Segment storeSegment;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "store_products",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> storeProducts;

    @OneToMany(mappedBy = "orderStore", fetch = FetchType.LAZY)
    private List<Order> storeOrders;

    @ManyToMany(mappedBy = "userStores", fetch = FetchType.LAZY)
    private List<User> storeUser;

}
