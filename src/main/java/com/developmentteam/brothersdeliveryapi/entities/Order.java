package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "order", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderId;

    @Column(name =  "orderAddressId")
    private Long orderAddressId;

    @Column(name =  "orderCardId")
    private Long orderCardId;

    @Column(name =  "orderStatus")
    private String orderStatus;

    @OneToOne(mappedBy = "deliveryOrder")
    private Delivery orderDelivery;

    @OneToOne(mappedBy = "paymentOrder")
    private Payment orderPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeId", referencedColumnName = "storeId", nullable = false)
    private Store orderStore;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItems> orderItems;

}
