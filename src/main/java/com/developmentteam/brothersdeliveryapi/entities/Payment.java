package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "payment", schema = "public")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Long paymentId;

    @Column(name = "paymentAmount")
    private BigDecimal paymentAmount;

    @OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", nullable = false)
    private Order paymentOrder;

}
