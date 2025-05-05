package com.proyectobases.taxones.repo;

import com.proyectobases.taxones.model.Taxon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaxonRepo extends JpaRepository<Taxon, Long> {
}
