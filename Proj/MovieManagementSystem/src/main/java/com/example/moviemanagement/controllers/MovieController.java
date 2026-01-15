package com.example.moviemanagement.controllers;

import com.example.moviemanagement.models.Movie;
import com.example.moviemanagement.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // GET /movies - Get all movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // GET /movies/{id} - Get movie by ID
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return movie.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /movies/search?title=... - Search movies by title
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMoviesByTitle(@RequestParam String title) {
        List<Movie> movies = movieService.searchMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }

    // GET /movies/genre/{genreName} - Get movies by genre
    @GetMapping("/genre/{genreName}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genreName) {
        List<Movie> movies = movieService.getMoviesByGenre(genreName);
        return ResponseEntity.ok(movies);
    }

    // POST /movies - Create new movie
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.createMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    // PUT /movies/{id} - Update movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Optional<Movie> updatedMovie = movieService.updateMovie(id, movie);
        return updatedMovie.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /movies/{id} - Delete movie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        boolean deleted = movieService.deleteMovie(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}