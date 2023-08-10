package com.developmentteam.brothersdeliveryapi.entities.auth;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refresh_token", schema = "public")
public class RefreshToken {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "refreshTokenId")
   private Long refreshTokenId;

   @Column(name = "refreshToken", nullable = false, length = 200)
   private String refreshToken;

   @Column(name = "refreshCodeExpiryAt", nullable = false)
   private LocalDateTime refreshTokenExpiryAt;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
   private User refreshTokenUser;

}
