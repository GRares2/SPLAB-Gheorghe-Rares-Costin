package com.example.lab1.commands;

import com.example.lab1.models.Book;
import com.example.lab1.services.BooksService;
import java.util.Optional;

class GetBookByIdCommand implements Command<Optional<Book>> {
    private final BooksService booksService;
    private final Long bookId;

    public GetBookByIdCommand(BooksService booksService, Long bookId) {
        this.booksService = booksService;
        this.bookId = bookId;
    }

    @Override
    public Optional<Book> execute() {
        System.out.println("Executing GetBookByIdCommand for id: " + bookId);
        return booksService.getBookById(bookId);
    }
}