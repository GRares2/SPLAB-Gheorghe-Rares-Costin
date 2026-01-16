package com.example.moviemanagement.models;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }
}