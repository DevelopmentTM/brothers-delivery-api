package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Order", schema = "default")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderId;

    @Column
    private String addressId;

    @Column
    private String cardId;

    @Column
    private String userId;

    @Column
    private String status;

    @Column
    private String storeId;

    @OneToMany()
    private List<OrderItems> orderItens;

    @OneToOne(mappedBy = "deliveryOrder")
    private Delivery orderDelivery;

    @OneToOne()
    @JoinColumn(name = "payment_id")
    private Payment orderPayment;

    @ManyToOne()
    @JoinColumn(name = "store_id")
    private Stores stores;

    @OneToMany(mappedBy = "orderItemId")
    private List<OrderItems> orderItems;

}
