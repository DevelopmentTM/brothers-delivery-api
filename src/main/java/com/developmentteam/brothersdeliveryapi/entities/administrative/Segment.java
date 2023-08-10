package com.developmentteam.brothersdeliveryapi.entities.administrative;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    @Column(name = "segmentNome", nullable = true, length = 50)
    private String segmentNome;

    @Column(name = "segmentDescription", length = 255)
    private String segmentDescription;

    @OneToMany(mappedBy = "storeSegment", fetch = FetchType.LAZY)
    private List<Store> segmentStores;

}