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
@Table(name = "address", schema = "public")
public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name =  "addressId")
   private Long addressId;

   @Column(name =  "addressCity", nullable = false, length = 40)
   private String addressCity;

   @Column(name =  "addressState", nullable = false, length = 20)
   private String addressState;

   @Column(name =  "addressStreet", nullable = false, length = 255)
   private String addressStreet;

   @Column(name =  "addressComplement", nullable = false, length = 255)
   private String addressComplement;

   @Column(name =  "addressNumber", nullable = false)
   private Integer addressNumber;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
   private User addressUser;
}
