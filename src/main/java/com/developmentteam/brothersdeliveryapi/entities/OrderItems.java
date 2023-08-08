package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Order_Items", schema = "default")
public class OrderItems {

    @EmbeddedId
    private OrderItemId orderItemId;

    @ManyToOne()
    @MapsId("orderId")
    private Order order;

    @ManyToOne()
    @MapsId("productId")
    private Product product;

    @Column
    private String productId;

    @Column
    private String orderId;

    @Column
    private Integer quantity;

}
