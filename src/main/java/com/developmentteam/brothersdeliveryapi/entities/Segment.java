package com.developmentteam.brothersdeliveryapi.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "segment", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "segmentId")
    private Long segmentId;

    @Column(name = "segmentNome")
    private String segmentNome;

    @Column(name = "segmentDescription")
    private String segmentDescription;

    @OneToMany(mappedBy = "storeSegment", fetch = FetchType.LAZY)
    private List<Store> segmentStores;

}