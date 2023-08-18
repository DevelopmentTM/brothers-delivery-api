package com.developmentteam.brothersdeliveryapi.repositories.administrative;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long>{


}
