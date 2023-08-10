package com.developmentteam.brothersdeliveryapi.repositories.deliveries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.developmentteam.brothersdeliveryapi.entities.deliveries.Occurrence;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {
}
