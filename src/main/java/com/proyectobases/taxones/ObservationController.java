package com.proyectobases.taxones;

import com.proyectobases.taxones.model.Identification;
import com.proyectobases.taxones.model.Observation;
import com.proyectobases.taxones.repo.IdentificationRepo;
import com.proyectobases.taxones.repo.ObservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ObservationController {

    @Autowired
    ObservationRepo observationRepo;
    @Autowired
    IdentificationRepo identificationRepo;

    @PostMapping("/observations")
    public void addObservation(@RequestBody Observation observation){
        observationRepo.save(observation);
    }

    @GetMapping("/observations/{id}")
    public ResponseEntity<Observation> getObservationById(@PathVariable Long id) {
        return observationRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/observations")
    public List<Observation> getAllObservations(){
        return observationRepo.findAll();
    }

    @GetMapping("/observations/user/{userId}")
    public List<Observation> getAllUserObservations(@PathVariable Long userId) {
        return observationRepo.findByUserId(userId);
    }


    @DeleteMapping("observations/{id}")
    public ResponseEntity<Void> deleteObservation(@PathVariable Long id) {
        Optional<Observation> observationOptional = observationRepo.findById(id);
        if (observationOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Observation observation = observationOptional.get();
        List<Identification> linkedIdentifications = identificationRepo.findByObservationId(id);
        identificationRepo.deleteAll(linkedIdentifications);
        observationRepo.delete(observation);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/observations/{id}")
    public ResponseEntity<Observation> updateObservation(@PathVariable Long id, @RequestBody Observation newObservation) {
        return observationRepo.findById(id).map(observation -> {
            observation.setComment(newObservation.getComment());
            observation.setTaxon(newObservation.getTaxon());
            observation.setDate(newObservation.getDate());
            observation.setSite(newObservation.getSite());
            observation.setImage(newObservation.getImage());
            observation.setUser(newObservation.getUser());
            return ResponseEntity.ok(observationRepo.save(observation));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

