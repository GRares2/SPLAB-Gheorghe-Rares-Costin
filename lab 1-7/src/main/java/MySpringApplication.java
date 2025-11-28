package com.example.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringApplication.class, args);
        System.out.println("Books REST API is running on port 8080");
        System.out.println("Available endpoints:");
        System.out.println("  GET    http://localhost:8080/books");
        System.out.println("  GET    http://localhost:8080/books/{id}");
        System.out.println("  POST   http://localhost:8080/books");
        System.out.println("  PUT    http://localhost:8080/books/{id}");
        System.out.println("  DELETE http://localhost:8080/books/{id}");

    }
}