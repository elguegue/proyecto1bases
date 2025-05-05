package com.proyectobases.taxones;

import com.proyectobases.taxones.model.Taxon;
import com.proyectobases.taxones.repo.TaxonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaxonController {

    @Autowired
    TaxonRepo taxonRepo;

    @GetMapping("/taxons/{id}")
    public ResponseEntity<Taxon> getTaxonById(@PathVariable Long id) {
        return taxonRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/taxons")
    public List<Taxon> getAllTaxons() {
        return taxonRepo.findAll();
    }

}

