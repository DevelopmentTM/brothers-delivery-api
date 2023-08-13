package com.developmentteam.brothersdeliveryapi.repositories.auth;

import com.developmentteam.brothersdeliveryapi.entities.auth.ResetCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResetCodeRepository extends JpaRepository<ResetCode, Long> {

   @Query("""
      SELECT rc FROM ResetCode rc
      INNER JOIN User u ON rc.resetCodeUser.userId = u.userId
      WHERE u.userEmail = :email AND rc.resetCode = :code
   """)
   Optional<ResetCode> findResetPasswordCodeByEmailAndCode(String email, Integer code);

   @Query("""
      SELECT rc FROM ResetCode rc
      INNER JOIN User u ON rc.resetCodeUser.userId = u.userId
      WHERE u.userId = :userId AND rc.resetCodeActive = true
   """)
   List<ResetCode> findActiveCodes(Long userId);

   @Modifying
   @Query("""
      UPDATE ResetCode rc SET rc.resetCodeActive = false
      WHERE rc.resetCodeUser.userId = :userId
   """)
   void deactivateResetCodesForUser(@Param("userId") Long userId);

}
