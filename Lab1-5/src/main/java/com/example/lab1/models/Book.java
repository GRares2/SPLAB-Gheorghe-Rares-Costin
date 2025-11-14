package com.example.lab1.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Long id;  // NEW FIELD
    private String title;
    private List<Author> authors;
    private TableOfContents tableOfContents;
    private List<Element> content;

    public Book() {
        this.authors = new ArrayList<>();
        this.content = new ArrayList<>();
    }

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.content = new ArrayList<>();
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Element> getContent() {
        return content;
    }

    public void setContent(List<Element> content) {
        this.content = content;
    }

    public TableOfContents getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(TableOfContents tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    
    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        content.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println();

        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println();

        for (Element element : content) {
            element.print();
        }
    }

}
