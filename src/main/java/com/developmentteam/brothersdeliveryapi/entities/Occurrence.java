package com.developmentteam.brothersdeliveryapi.entities;

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
    private long occurrenceId;

    @Column
    private String occurrenceDescription;

    @Column
    private LocalDateTime occurrenceDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryId", referencedColumnName = "deliveryId", nullable = false)
    private Delivery occurrenceDelivery;

}
