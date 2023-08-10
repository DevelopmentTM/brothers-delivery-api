package com.developmentteam.brothersdeliveryapi.repositories.orders;

import com.developmentteam.brothersdeliveryapi.entities.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
