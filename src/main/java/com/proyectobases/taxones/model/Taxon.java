package com.proyectobases.taxones.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "taxon")
public class Taxon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String common_name;

    @Column(nullable = true)
    private String species_name;

    @Column(nullable = true)
    private Long taxon_ancestor_id;
}
