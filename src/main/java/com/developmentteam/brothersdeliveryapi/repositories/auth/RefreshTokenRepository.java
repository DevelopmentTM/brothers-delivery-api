package com.developmentteam.brothersdeliveryapi.repositories.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

   Optional<RefreshToken> findByRefreshToken(String refreshToken);

   @Query("SELECT rt FROM RefreshToken rt WHERE rt.refreshTokenUser.userId = :userId")
   Optional<RefreshToken> findRefreshTokenByUser(@Param("userId") Long userId);

}
