package com.developmentteam.brothersdeliveryapi.dto.response.administrative;

import com.developmentteam.brothersdeliveryapi.entities.orders.Order;

import java.io.Serializable;

public record StoreOrdersResponse(
        Long orderId,
        Long userId,
        String orderStatus) implements Serializable {

    public static StoreOrdersResponse toResponse(Order order) {

        return new StoreOrdersResponse(
                order.getOrderId(),
                order.getOrderUserId(),
                order.getOrderStatus()
        );
    }
}
