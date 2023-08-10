package com.developmentteam.brothersdeliveryapi.entities.orders;

import com.developmentteam.brothersdeliveryapi.entities.payment.Payment;
import com.developmentteam.brothersdeliveryapi.entities.Store;
import com.developmentteam.brothersdeliveryapi.entities.deliveries.Delivery;
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
    @Column(name = "orderId", nullable = false)
    private Long orderId;

    @Column(name =  "orderAddressId", nullable = false)
    private Long orderAddressId;

    @Column(name =  "orderCardId", nullable = false)
    private Long orderCardId;

    @Column(name =  "orderStatus", nullable = false, length = 20)
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
