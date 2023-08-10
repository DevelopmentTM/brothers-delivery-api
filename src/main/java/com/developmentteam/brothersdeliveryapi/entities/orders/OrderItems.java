package com.developmentteam.brothersdeliveryapi.entities.orders;

import com.developmentteam.brothersdeliveryapi.entities.OrderItemPrimaryKey;
import com.developmentteam.brothersdeliveryapi.entities.Product;
import com.developmentteam.brothersdeliveryapi.entities.orders.Order;
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

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
