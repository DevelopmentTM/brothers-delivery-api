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
    @Column(name = "occurrence_id", nullable = false)
    private Long occurrenceId;

    @Column(name = "occurrence_description", nullable = false, length = 255)
    private String occurrenceDescription;

    @Column(name = "occurrence_date", nullable = false)
    private LocalDateTime occurrenceDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id", referencedColumnName = "delivery_id", nullable = false)
    private Delivery occurrenceDelivery;

}
