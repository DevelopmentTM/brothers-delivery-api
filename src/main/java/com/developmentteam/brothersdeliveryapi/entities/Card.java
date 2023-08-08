package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Card", schema = "public")
public class Card {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "cardId")
   private Long cardId;

   @Column(name = "cardNumber")
   private Integer cardNumber;

   @Column(name = "cardCvv")
   private String cardCvv;

   @Column(name = "cardExpiration")
   private String cardExpiration;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
   private User cardUser;

}
