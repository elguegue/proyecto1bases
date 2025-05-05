package com.proyectobases.taxones.repo;

import com.proyectobases.taxones.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SiteRepo extends JpaRepository<Site, Long> {
}
