package com.example.moviemanagement.controllers;

import com.example.moviemanagement.models.Actor;
import com.example.moviemanagement.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
@CrossOrigin(origins = "*")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        return actorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Actor createActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable Long id, @RequestBody Actor actorDetails) {
        return actorRepository.findById(id)
                .map(actor -> {
                    actor.setName(actorDetails.getName());
                    actor.setBirthYear(actorDetails.getBirthYear());
                    actor.setNationality(actorDetails.getNationality());
                    return ResponseEntity.ok(actorRepository.save(actor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        return actorRepository.findById(id)
                .map(actor -> {
                    actorRepository.delete(actor);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}