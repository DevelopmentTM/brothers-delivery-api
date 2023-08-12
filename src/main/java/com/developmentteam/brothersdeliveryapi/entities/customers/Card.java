package com.developmentteam.brothersdeliveryapi.entities.customers;

import com.developmentteam.brothersdeliveryapi.entities.auth.User;
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
@Table(name = "card", schema = "public")
public class Card {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "card_id")
   private Long cardId;

   @Column(name = "card_number", nullable = false)
   private Integer cardNumber;

   @Column(name = "card_cvv", nullable = false, length = 3)
   private String cardCvv;

   @Column(name = "card_expiration", nullable = false)
   private String cardExpiration;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
   private User cardUser;

}
