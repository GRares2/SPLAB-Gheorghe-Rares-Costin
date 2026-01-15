package com.example.moviemanagement.services;

import com.example.moviemanagement.models.Movie;
import com.example.moviemanagement.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getMoviesByGenre(String genreName) {
        return movieRepository.findByGenres_NameIgnoreCase(genreName);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> updateMovie(Long id, Movie updatedMovie) {
        return movieRepository.findById(id)
                .map(existingMovie -> {
                    existingMovie.setTitle(updatedMovie.getTitle());
                    existingMovie.setReleaseYear(updatedMovie.getReleaseYear());
                    existingMovie.setDuration(updatedMovie.getDuration());
                    existingMovie.setRating(updatedMovie.getRating());
                    existingMovie.setSummary(updatedMovie.getSummary());
                    existingMovie.setDirector(updatedMovie.getDirector());
                    existingMovie.setActors(updatedMovie.getActors());
                    existingMovie.setGenres(updatedMovie.getGenres());
                    return movieRepository.save(existingMovie);
                });
    }

    public boolean deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}