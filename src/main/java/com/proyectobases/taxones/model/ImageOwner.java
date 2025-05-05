package com.proyectobases.taxones.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ImageOwner")
public class ImageOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
