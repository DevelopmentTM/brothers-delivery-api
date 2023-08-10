package com.developmentteam.brothersdeliveryapi.repositories.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
