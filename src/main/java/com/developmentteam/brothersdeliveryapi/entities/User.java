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
@Table(name = "User", schema = "default")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
