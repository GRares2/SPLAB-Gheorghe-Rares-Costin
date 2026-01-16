package com.example.moviemanagement.models;

import lombok.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
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
    private Director director;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    public Movie(String title, Integer releaseYear, Integer duration) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.actors = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }
}