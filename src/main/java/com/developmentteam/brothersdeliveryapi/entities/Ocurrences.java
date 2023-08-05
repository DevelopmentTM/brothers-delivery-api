package com.developmentteam.brothersdeliveryapi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Ocurrences", schema = "default")
public class Ocurrences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ocurrenceId;

}
