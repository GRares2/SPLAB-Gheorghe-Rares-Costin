package com.example.lab1.commands;

import com.example.lab1.models.Book;
import com.example.lab1.services.BooksService;

class CreateBookCommand implements Command<Book> {
    private final BooksService booksService;
    private final Book book;

    public CreateBookCommand(BooksService booksService, Book book) {
        this.booksService = booksService;
        this.book = book;
    }

    @Override
    public Book execute() {
        System.out.println("Executing CreateBookCommand");
        return booksService.createBook(book);
    }
}