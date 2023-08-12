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
   @Column(name =  "address_id")
   private Long addressId;

   @Column(name =  "address_city", nullable = false, length = 40)
   private String addressCity;

   @Column(name =  "address_state", nullable = false, length = 20)
   private String addressState;

   @Column(name =  "address_street", nullable = false, length = 255)
   private String addressStreet;

   @Column(name =  "address_complement", nullable = false, length = 255)
   private String addressComplement;

   @Column(name =  "address_number", nullable = false)
   private Integer addressNumber;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
   private User addressUser;
}
