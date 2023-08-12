package com.developmentteam.brothersdeliveryapi.entities.auth;


import com.developmentteam.brothersdeliveryapi.entities.customers.Address;
import com.developmentteam.brothersdeliveryapi.entities.customers.Card;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user", schema = "public")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "user_id")
   private Long userId;

   @Column(name = "user_name", nullable = false, length = 100)
   private String userName;

   @Column(name = "user_email", nullable = false, length = 100)
   private String userEmail;

   @Column(name = "user_password", nullable = false, length = 50)
   private String userPassword;

   @Column(name = "user_phone", nullable = false,  length = 15)
   private String userPhone;

   @Column(name = "user_cpf", nullable = false, length = 30)
   private String userCpf;

   @OneToMany(mappedBy = "cardUser", fetch = FetchType.LAZY)
   private List<Card> userCards;

   @OneToMany(mappedBy = "addressUser", fetch = FetchType.LAZY)
   private List<Address> userAddress;

   @OneToMany(mappedBy = "resetCodeUser", fetch = FetchType.LAZY)
   private List<ResetCode> userResetCoders;

   @OneToOne(mappedBy = "refreshTokenUser")
   private RefreshToken userRefreshToken;

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(
           name = "user_roles",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id")
   )
   private List<Role> userRoles;

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(
           name = "Favorites",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "store_id")
   )
   private List<Store> userStores;

}
