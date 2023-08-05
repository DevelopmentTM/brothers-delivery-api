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
public class ResetToken {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column()
   private Long resetCodeId;

   @Column()
   private String refreshCode;

   @Column()
   private LocalDateTime refreshCodeExpiryAt;

}
