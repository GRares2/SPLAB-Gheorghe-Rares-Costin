package com.example.moviemanagement.models;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "directors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer birthYear;
    private String nationality;

    public Director(String name, Integer birthYear, String nationality) {
        this.name = name;
        this.birthYear = birthYear;
        this.nationality = nationality;
    }
}