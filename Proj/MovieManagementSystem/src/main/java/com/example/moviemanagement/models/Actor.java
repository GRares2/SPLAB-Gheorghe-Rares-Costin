package com.example.moviemanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "actors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer birthYear;
    private String nationality;

    public Actor() {
    }

    public Actor(String name, Integer birthYear, String nationality) {
        this.name = name;
        this.birthYear = birthYear;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}