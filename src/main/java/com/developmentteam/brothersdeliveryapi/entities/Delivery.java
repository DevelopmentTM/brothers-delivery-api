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
@Table(name = "Delivery", schema = "default")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliveryId")
    private Long deliveryId;

    private LocalDateTime deliveryStart;

    private LocalDateTime deliveryEnd;

    @OneToMany(mappedBy = "occurrenceDelivery")
    private List<Occurrence> deliveryOccurrence;

    @OneToOne()
    @JoinColumn(name = "order_id")
    private Order deliveryOrder;

}
