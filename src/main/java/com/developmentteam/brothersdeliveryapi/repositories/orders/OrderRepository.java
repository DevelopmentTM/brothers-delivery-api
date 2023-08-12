package com.developmentteam.brothersdeliveryapi.repositories.orders;

import com.developmentteam.brothersdeliveryapi.entities.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT order FROM Order order WHERE order.orderId = :orderId")
    List<Order> findAllOrderByStoreId(@Param("orderId") Long orderId);

}
