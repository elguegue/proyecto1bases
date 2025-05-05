package com.proyectobases.taxones.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "identification")
public class Identification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Account user;

    @ManyToOne
    @JoinColumn
    private Taxon taxon;

    @ManyToOne
    @JoinColumn
    private Observation observation;

    @Column(nullable = false)
    private Date date;
}

