package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Occurrence", schema = "default")
public class Occurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long occurrenceId;

    @Column
    private String occurrenceDescription;

    @Column
    private LocalDateTime occurrenceDate;

    @ManyToOne()
    @JoinColumn(name = "delivery_id")
    private Delivery occurrenceDelivery;

}
