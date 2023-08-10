package com.developmentteam.brothersdeliveryapi.entities.deliveries;

import com.developmentteam.brothersdeliveryapi.entities.deliveries.Delivery;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "occurrence", schema = "public")
public class Occurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "occurrenceId", nullable = false)
    private Long occurrenceId;

    @Column(name = "occurrenceDescription", nullable = false, length = 255)
    private String occurrenceDescription;

    @Column(name = "occurrenceDate", nullable = false)
    private LocalDateTime occurrenceDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryId", referencedColumnName = "deliveryId", nullable = false)
    private Delivery occurrenceDelivery;

}
