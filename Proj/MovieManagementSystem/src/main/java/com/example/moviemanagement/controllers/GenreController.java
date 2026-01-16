package com.example.moviemanagement.controllers;

import com.example.moviemanagement.models.Genre;
import com.example.moviemanagement.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@CrossOrigin(origins = "*")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        return genreRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genreDetails) {
        return genreRepository.findById(id)
                .map(genre -> {
                    genre.setName(genreDetails.getName());
                    genre.setDescription(genreDetails.getDescription());
                    return ResponseEntity.ok(genreRepository.save(genre));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        return genreRepository.findById(id)
                .map(genre -> {
                    genreRepository.delete(genre);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}