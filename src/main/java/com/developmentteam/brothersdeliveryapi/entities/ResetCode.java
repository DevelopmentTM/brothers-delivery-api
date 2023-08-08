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
@Table(name = "ResetCode", schema = "public")
public class ResetCode {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "resetCodeId")
   private Long resetCodeId;

   @Column(name =  "refreshCode")
   private String refreshCode;

   @Column(name =  "refreshCodeExpiryAt")
   private LocalDateTime refreshCodeExpiryAt;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
   private User resetCodeUser;

}
