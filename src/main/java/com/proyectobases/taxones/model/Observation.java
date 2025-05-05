package com.proyectobases.taxones.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "observation")
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Site site;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Image image;

    @ManyToOne
    @JoinColumn
    private Taxon taxon;

    @ManyToOne
    @JoinColumn
    private Account user;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private Date date;

}
