package com.example.lab1.commands;

import com.example.lab1.models.Book;
import com.example.lab1.services.BooksService;
import java.util.List;

class GetAllBooksCommand implements Command<List<Book>> {
    private final BooksService booksService;

    public GetAllBooksCommand(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public List<Book> execute() {
        System.out.println("Executing GetAllBooksCommand");
        return booksService.getAllBooks();
    }
}