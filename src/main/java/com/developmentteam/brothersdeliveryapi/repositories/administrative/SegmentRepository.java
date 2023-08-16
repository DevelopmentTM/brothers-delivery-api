package com.developmentteam.brothersdeliveryapi.repositories.administrative;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;
import org.springframework.data.jpa.repository.Query;

public interface SegmentRepository extends JpaRepository<Segment, Long> {

//    @Query("SELECT segment FROM Segment segment WHERE segment.")
//    Segment findSegmentByStoreId(Long storeId);
//
}
