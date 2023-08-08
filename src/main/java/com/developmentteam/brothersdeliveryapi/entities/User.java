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
@Table(name = "User", schema = "default")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "userId")
   private Long userId;

   @Column()
   private  String userName;

   @Column()
   private String userEmail;

   @Column()
   private String userPassword;

   @Column()
   private String userPhone;

   @Column()
   private  String userCpf;

   @OneToMany(mappedBy = "cardUser")
   private List<Card> userCards;

   @OneToMany(mappedBy = "addressUser")
   private List<Address> userAddress;

   @OneToMany(mappedBy = "resetCodeUser")
   private List<ResetCode> userResetCoders;

   @OneToOne(mappedBy = "refreshTokenUser")
   private RefreshToken userRefreshToken;

   @ManyToMany
   @JoinTable(
           name = "user_role",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id"))
   private List<Role> userRoles;

}
