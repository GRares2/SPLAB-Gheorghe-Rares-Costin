package com.example.moviemanagement.controllers;

import com.example.moviemanagement.models.Movie;
import com.example.moviemanagement.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(movieDetails.getTitle());
                    movie.setReleaseYear(movieDetails.getReleaseYear());
                    movie.setDuration(movieDetails.getDuration());
                    movie.setRating(movieDetails.getRating());
                    movie.setSummary(movieDetails.getSummary());
                    movie.setDirector(movieDetails.getDirector());
                    movie.setActors(movieDetails.getActors());
                    movie.setGenres(movieDetails.getGenres());
                    return ResponseEntity.ok(movieRepository.save(movie));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movieRepository.delete(movie);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}