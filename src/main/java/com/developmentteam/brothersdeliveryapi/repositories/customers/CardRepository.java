package com.developmentteam.brothersdeliveryapi.repositories.customers;

import com.developmentteam.brothersdeliveryapi.entities.customers.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
