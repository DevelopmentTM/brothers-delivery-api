package com.developmentteam.brothersdeliveryapi.repositories.deliveries;

import com.developmentteam.brothersdeliveryapi.entities.deliveries.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Long, Delivery> {
}
