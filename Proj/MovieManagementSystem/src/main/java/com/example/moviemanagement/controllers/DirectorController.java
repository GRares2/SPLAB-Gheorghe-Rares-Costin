package com.example.moviemanagement.controllers;

import com.example.moviemanagement.models.Director;
import com.example.moviemanagement.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    // GET /directors - Get all directors
    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return ResponseEntity.ok(directors);
    }

    // GET /directors/{id} - Get director by ID
    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        Optional<Director> director = directorService.getDirectorById(id);
        return director.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /directors - Create new director
    @PostMapping
    public ResponseEntity<Director> createDirector(@RequestBody Director director) {
        Director createdDirector = directorService.createDirector(director);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDirector);
    }

    // PUT /directors/{id} - Update director
    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable Long id, @RequestBody Director director) {
        Optional<Director> updatedDirector = directorService.updateDirector(id, director);
        return updatedDirector.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /directors/{id} - Delete director
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        boolean deleted = directorService.deleteDirector(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}