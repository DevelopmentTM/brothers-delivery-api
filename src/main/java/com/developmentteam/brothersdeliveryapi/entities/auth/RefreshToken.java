package com.developmentteam.brothersdeliveryapi.entities.auth;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refresh_token", schema = "public")
public class RefreshToken {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "refresh_token_id")
   private Long refreshTokenId;

   @Column(name = "refresh_token", nullable = false, length = 200)
   private String refreshToken;

   @Column(name = "refresh_token_expiry_at", nullable = false)
   private LocalDateTime refreshTokenExpiryAt;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
   private User refreshTokenUser;

}
