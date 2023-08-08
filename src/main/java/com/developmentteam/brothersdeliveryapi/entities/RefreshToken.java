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
@Table(name = "ResetToken", schema = "default")
public class RefreshToken {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "refreshTokenId")
   private Long refreshTokenId;

   @Column()
   private String refreshCode;

   @Column()
   private LocalDateTime refreshCodeExpiryAt;

   @OneToOne()
   @JoinColumn(name = "user_id")
   private User refreshTokenUser;

}
