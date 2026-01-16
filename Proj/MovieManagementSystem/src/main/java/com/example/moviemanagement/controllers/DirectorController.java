package com.example.moviemanagement.controllers;

import com.example.moviemanagement.models.Director;
import com.example.moviemanagement.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
@CrossOrigin(origins = "*")
public class DirectorController {

    @Autowired
    private DirectorRepository directorRepository;

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        return directorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorRepository.save(director);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable Long id, @RequestBody Director directorDetails) {
        return directorRepository.findById(id)
                .map(director -> {
                    director.setName(directorDetails.getName());
                    director.setBirthYear(directorDetails.getBirthYear());
                    director.setNationality(directorDetails.getNationality());
                    return ResponseEntity.ok(directorRepository.save(director));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        return directorRepository.findById(id)
                .map(director -> {
                    directorRepository.delete(director);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}