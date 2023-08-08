package com.developmentteam.brothersdeliveryapi.entities;

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
@Table(name = "RefreshToken", schema = "public")
public class RefreshToken {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "refreshTokenId")
   private Long refreshTokenId;

   @Column(name = "refreshCode")
   private String refreshCode;

   @Column(name = "refreshCodeExpiryAt")
   private LocalDateTime refreshCodeExpiryAt;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
   private User refreshTokenUser;

}
