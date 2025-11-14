package com.example.lab1.models;

public class TableOfContents {
    private String title;

    public TableOfContents() {
        this.title = "Table of Contents";
    }

    public TableOfContents(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println(title);
    }
}