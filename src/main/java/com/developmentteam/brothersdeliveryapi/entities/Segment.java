package com.developmentteam.brothersdeliveryapi.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Segment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "segmentId")
    private long segmentId;

    @Column(name = "segmentNome")
    private String segmentNome;

    @Column(name = "segmentDescription")
    private String segmentDescription;

    @OneToMany(mappedBy = "segment")
    private List<Stores> stores;

}