package com.example.moviemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer releaseYear;
    private Integer duration;
    private Double rating;
    private String summary;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "director_id")
    private com.example.moviemanagement.models.Director director;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<com.example.moviemanagement.models.Actor> actors;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<com.example.moviemanagement.models.Genre> genres;

    public Movie() {
        this.actors = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public Movie(String title, Integer releaseYear, Integer duration) {
        this();
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public com.example.moviemanagement.models.Director getDirector() {
        return director;
    }

    public void setDirector(com.example.moviemanagement.models.Director director) {
        this.director = director;
    }

    public List<com.example.moviemanagement.models.Actor> getActors() {
        return actors;
    }

    public void setActors(List<com.example.moviemanagement.models.Actor> actors) {
        this.actors = actors;
    }

    public List<com.example.moviemanagement.models.Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<com.example.moviemanagement.models.Genre> genres) {
        this.genres = genres;
    }

    public void addActor(com.example.moviemanagement.models.Actor actor) {
        this.actors.add(actor);
    }

    public void addGenre(com.example.moviemanagement.models.Genre genre) {
        this.genres.add(genre);
    }
}