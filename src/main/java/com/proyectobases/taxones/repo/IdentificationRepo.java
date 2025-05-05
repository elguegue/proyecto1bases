package com.proyectobases.taxones.repo;

import com.proyectobases.taxones.model.Identification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface IdentificationRepo extends JpaRepository<Identification, Long> {
    List<Identification> findByObservationId(Long id);
    List<Identification> findByUserId(Long userId);
}
