package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Delivery", schema = "public")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliveryId")
    private Long deliveryId;

    @Column(name = "deliveryStart")
    private LocalDateTime deliveryStart;

    @Column(name = "deliveryEnd")
    private LocalDateTime deliveryEnd;

    @OneToMany(mappedBy = "occurrenceDelivery", fetch = FetchType.LAZY)
    private List<Occurrence> deliveryOccurrence;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", nullable = false)
    private Order deliveryOrder;

}
