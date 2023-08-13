package com.developmentteam.brothersdeliveryapi.entities.auth;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reset_code", schema = "public")
public class ResetCode {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "reset_code_id")
   private Long resetCodeId;

   @Column(name =  "reset_code", nullable = false, length = 255)
   private Integer resetCode;

   @Column(name =  "reset_code_expiry_at", nullable = false)
   private LocalDateTime resetCodeExpiryAt;

   @Column(name = "reset_code_active", nullable = false)
   private boolean resetCodeActive;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
   private User resetCodeUser;

}
