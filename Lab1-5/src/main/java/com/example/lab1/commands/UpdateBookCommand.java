package com.example.lab1.commands;

import com.example.lab1.models.Book;
import com.example.lab1.services.BooksService;
import java.util.Optional;

class UpdateBookCommand implements Command<Optional<Book>> {
    private final BooksService booksService;
    private final Long bookId;
    private final Book updatedBook;

    public UpdateBookCommand(BooksService booksService, Long bookId, Book updatedBook) {
        this.booksService = booksService;
        this.bookId = bookId;
        this.updatedBook = updatedBook;
    }

    @Override
    public Optional<Book> execute() {
        System.out.println("Executing UpdateBookCommand for id: " + bookId);
        return booksService.updateBook(bookId, updatedBook);
    }
}