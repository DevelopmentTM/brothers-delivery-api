package com.developmentteam.brothersdeliveryapi.entities.auth;


import com.developmentteam.brothersdeliveryapi.entities.customers.Address;
import com.developmentteam.brothersdeliveryapi.entities.customers.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.developmentteam.brothersdeliveryapi.entities.administrative.Store;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user", schema = "public")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "userId")
   private Long userId;

   @Column(name = "userName", nullable = false, length = 100)
   private String userName;

   @Column(name = "userEmail", nullable = false, length = 100)
   private String userEmail;

   @Column(name = "userPassword", nullable = false, length = 50)
   private String userPassword;

   @Column(name = "userPhone", nullable = false,  length = 15)
   private String userPhone;

   @Column(name = "userCpf", nullable = false, length = 30)
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
           joinColumns = @JoinColumn(name = "userId"),
           inverseJoinColumns = @JoinColumn(name = "roleId")
   )
   private List<Role> userRoles;

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(
           name = "Favorites",
           joinColumns = @JoinColumn(name = "userId"),
           inverseJoinColumns = @JoinColumn(name = "storeId")
   )
   private List<Store> userStores;

}
