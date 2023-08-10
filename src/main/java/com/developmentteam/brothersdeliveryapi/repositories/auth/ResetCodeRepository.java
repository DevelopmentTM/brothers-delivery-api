package com.developmentteam.brothersdeliveryapi.repositories.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.ResetCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetCodeRepository extends JpaRepository<ResetCode, Long> {
}
