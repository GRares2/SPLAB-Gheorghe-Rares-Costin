package com.example.moviemanagement.models;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "actors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer birthYear;
    private String nationality;

    public Actor(String name, Integer birthYear, String nationality) {
        this.name = name;
        this.birthYear = birthYear;
        this.nationality = nationality;
    }
}