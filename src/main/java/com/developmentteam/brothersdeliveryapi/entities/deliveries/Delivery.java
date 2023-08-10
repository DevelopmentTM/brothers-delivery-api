package com.developmentteam.brothersdeliveryapi.entities.deliveries;

import com.developmentteam.brothersdeliveryapi.entities.orders.Order;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "delivery", schema = "public")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliveryId", nullable = false)
    private Long deliveryId;

    @Column(name = "deliveryStart", nullable = false)
    private LocalDateTime deliveryStart;

    @Column(name = "deliveryEnd", nullable = false)
    private LocalDateTime deliveryEnd;

    @OneToMany(mappedBy = "occurrenceDelivery", fetch = FetchType.LAZY)
    private List<Occurrence> deliveryOccurrence;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", nullable = false)
    private Order deliveryOrder;

}
