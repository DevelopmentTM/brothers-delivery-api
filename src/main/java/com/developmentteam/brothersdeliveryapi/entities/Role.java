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
@Table(name = "Role", schema = "default")
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "roleId")
   private Long roleId;

   @Column()
   private String roleName;

   @ManyToMany(mappedBy = "userRoles")
   private List<User> roleUsers;

}
