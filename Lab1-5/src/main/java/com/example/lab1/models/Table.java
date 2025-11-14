package com.example.lab1.models;

public class Table implements Element {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add to a Table");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove from a Table");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Cannot get from a Table");
    }
}