package com.proyectobases.taxones.repo;

import com.proyectobases.taxones.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ObservationRepo extends JpaRepository<Observation, Long> {
    List<Observation> findByUserId(Long userId);

}

