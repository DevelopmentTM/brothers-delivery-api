package com.developmentteam.brothersdeliveryapi.repositories.administrative;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{
    
}
