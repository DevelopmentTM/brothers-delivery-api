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
@Table(name = "Card", schema = "default")
public class Card {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cardId;

   @Column()
   private Integer cardNumber;

   @Column()
   private String cardCvv;

   @Column()
   private String cardExpiration;

}