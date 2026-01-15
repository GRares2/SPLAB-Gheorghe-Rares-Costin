package com.example.moviemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieManagementSystemApplication.class, args);
        System.out.println("Movie Management is running!");
        System.out.println("Available endpoints:");
        System.out.println("Movies:");
        System.out.println("  GET    http://localhost:8080/movies");
        System.out.println("  GET    http://localhost:8080/movies/{id}");
        System.out.println("  GET    http://localhost:8080/movies/search?title=...");
        System.out.println("  GET    http://localhost:8080/movies/genre/{genreName}");
        System.out.println("  POST   http://localhost:8080/movies");
        System.out.println("  PUT    http://localhost:8080/movies/{id}");
        System.out.println("  DELETE http://localhost:8080/movies/{id}");
        System.out.println();
        System.out.println("Directors:");
        System.out.println("  GET    http://localhost:8080/directors");
        System.out.println("  GET    http://localhost:8080/directors/{id}");
        System.out.println("  POST   http://localhost:8080/directors");
        System.out.println("  PUT    http://localhost:8080/directors/{id}");
        System.out.println("  DELETE http://localhost:8080/directors/{id}");
        System.out.println();
        System.out.println("H2 Console: http://localhost:8080/h2-console");

    }
}