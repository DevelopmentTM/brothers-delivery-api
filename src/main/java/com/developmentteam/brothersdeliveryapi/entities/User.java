package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

   @Column(name = "userName")
   private String userName;

   @Column(name = "userEmail")
   private String userEmail;

   @Column(name = "userPassword")
   private String userPassword;

   @Column(name = "userPhone")
   private String userPhone;

   @Column(name = "userCpf")
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
