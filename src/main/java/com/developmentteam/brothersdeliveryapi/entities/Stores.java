package com.developmentteam.brothersdeliveryapi.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Store")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "storeDescription")
    private String storeDescription;

    @Column(name = "segmentId")
    private Long segmentId;

    @Column(name = "assessment")
    private BigDecimal assessment;

    @Column(name = "startDelivery")
    private LocalDateTime startDelivery;

    @Column(name = "endDelivery")
    private LocalDateTime endDelivery;

}
