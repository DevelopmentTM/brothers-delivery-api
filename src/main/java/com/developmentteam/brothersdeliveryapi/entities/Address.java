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
@Table(name = "address", schema = "public")
public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name =  "addressId")
   private Long addressId;

   @Column(name =  "addressCity")
   private String addressCity;

   @Column(name =  "addressState")
   private String addressState;

   @Column(name =  "addressStreet")
   private String addressStreet;

   @Column(name =  "addressComplement")
   private String addressComplement;

   @Column(name =  "addressNumber")
   private Integer addressNumber;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
   private User addressUser;
}
