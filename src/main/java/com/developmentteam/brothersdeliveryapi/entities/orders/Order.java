package com.developmentteam.brothersdeliveryapi.entities.orders;

import com.developmentteam.brothersdeliveryapi.entities.payment.Payment;
import com.developmentteam.brothersdeliveryapi.entities.deliveries.Delivery;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "order", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name =  "order_address_id", nullable = false)
    private Long orderAddressId;

    @Column(name =  "order_card_id", nullable = false)
    private Long orderCardId;

    @Column(name= "order_user_id", nullable = false)
    private Long orderUserId;

    @Column(name =  "order_status", nullable = false, length = 20)
    private String orderStatus;

    @OneToOne(mappedBy = "deliveryOrder")
    private Delivery orderDelivery;

    @OneToOne(mappedBy = "paymentOrder")
    private Payment orderPayment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private Store orderStore;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItems> orderItems;

}
