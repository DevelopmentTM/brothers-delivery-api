package com.developmentteam.brothersdeliveryapi.repositories.orders;

import com.developmentteam.brothersdeliveryapi.entities.orders.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<Long, OrderItems> {
}
