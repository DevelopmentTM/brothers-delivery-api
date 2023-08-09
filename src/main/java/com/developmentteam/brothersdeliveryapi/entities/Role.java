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
@Table(name = "role", schema = "public")
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "roleId")
   private Long roleId;

   @Column(name =  "roleName")
   private String roleName;

   @ManyToMany(mappedBy = "userRoles", fetch = FetchType.LAZY)
   private List<User> roleUsers;

}
