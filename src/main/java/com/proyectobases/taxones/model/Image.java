package com.proyectobases.taxones.model;

import jakarta.persistence.*;
import lombok.Data;


import java.sql.Date;

@Data
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private Taxon taxon;

    @ManyToOne
    @JoinColumn
    private Account user;

    @ManyToOne
    @JoinColumn
    private License license;

    @ManyToOne
    @JoinColumn
    private ImageOwner imageOwner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Site site;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String url;
}
