package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ResetCode", schema = "default")
public class ResetCode {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "resetCodeId")
   private Long resetCodeId;

   @Column()
   private String refreshCode;

   @Column()
   private LocalDateTime refreshCodeExpiryAt;

   @ManyToOne()
   @JoinColumn(name = "user_id")
   private User resetCodeUser;

}
