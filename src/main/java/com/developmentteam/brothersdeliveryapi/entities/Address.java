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
@Table(name = "Address", schema = "default")
public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long addressId;

   @Column()
   private String addressCity;

   @Column()
   private String addressState;

   @Column()
   private String addressStreet;

   @Column()
   private String addressComplement;

   @Column()
   private Integer addressNumber;

   @ManyToOne
   @JoinColumn(name = "userId")
   private User addressUser;
}
