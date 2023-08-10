package com.developmentteam.brothersdeliveryapi.repositories.customers;

import com.developmentteam.brothersdeliveryapi.entities.customers.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
