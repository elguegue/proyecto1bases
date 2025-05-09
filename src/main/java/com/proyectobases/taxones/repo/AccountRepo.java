package com.proyectobases.taxones.repo;

import com.proyectobases.taxones.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountRepo extends JpaRepository<Account, Long> {
}

