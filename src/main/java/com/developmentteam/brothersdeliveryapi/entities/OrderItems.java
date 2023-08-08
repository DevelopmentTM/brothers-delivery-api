package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "order_items", schema = "public")
public class OrderItems {

    @EmbeddedId
    private OrderItemPrimaryKey orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

}
