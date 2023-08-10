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
   @Column(name = "cardId")
   private Long cardId;

   @Column(name = "cardNumber", nullable = false)
   private Integer cardNumber;

   @Column(name = "cardCvv", nullable = false, length = 3)
   private String cardCvv;

   @Column(name = "cardExpiration", nullable = false)
   private String cardExpiration;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
   private User cardUser;

}
