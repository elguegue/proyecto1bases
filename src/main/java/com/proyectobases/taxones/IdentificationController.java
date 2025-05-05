package com.proyectobases.taxones;

import com.proyectobases.taxones.model.Identification;
import com.proyectobases.taxones.repo.IdentificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IdentificationController {

    @Autowired
    IdentificationRepo identificationRepo;

    @PostMapping("/identifications")
    public void addIdentification(@RequestBody Identification identification){
        identificationRepo.save(identification);
    }

    @GetMapping("/identifications/{id}")
    public ResponseEntity<Identification> getIdentificationById(@PathVariable Long id) {
        return identificationRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/identifications")
    public List<Identification> getAllIdentifications(){
        return identificationRepo.findAll();
    }

    @GetMapping("/identifications/user/{userId}")
    public List<Identification> getAllUserIdentifications(@PathVariable Long userId) {
        return identificationRepo.findByUserId(userId);
    }


    @DeleteMapping("identifications/{id}")
    public ResponseEntity<Void> deleteIdentification(@PathVariable Long id) {
        if (identificationRepo.existsById(id)) {
            identificationRepo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/identifications/{id}")
    public ResponseEntity<Identification> updateIdentification(@PathVariable Long id, @RequestBody Identification newIdentification) {
        return identificationRepo.findById(id).map(identification -> {
            identification.setUser(newIdentification.getUser());
            identification.setTaxon(newIdentification.getTaxon());
            identification.setObservation(newIdentification.getObservation());
            identification.setDate(newIdentification.getDate());
            return ResponseEntity.ok(identificationRepo.save(identification));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
