package com.developmentteam.brothersdeliveryapi.repositories.administrative;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Segment;

public interface SegmentRepository extends JpaRepository<Segment, Long> {
    
}
