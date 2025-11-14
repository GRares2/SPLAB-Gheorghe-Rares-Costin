package com.example.lab1.commands;

import com.example.lab1.models.Book;
import com.example.lab1.services.BooksService;
import java.util.List;
import java.util.Optional;

public class CommandFactory {
    private final BooksService booksService;

    public CommandFactory(BooksService booksService) {
        this.booksService = booksService;
    }

    public Command<List<Book>> createGetAllBooksCommand() {
        return new GetAllBooksCommand(booksService);
    }

    public Command<Optional<Book>> createGetBookByIdCommand(Long id) {
        return new GetBookByIdCommand(booksService, id);
    }

    public Command<Book> createCreateBookCommand(Book book) {
        return new CreateBookCommand(booksService, book);
    }

    public Command<Optional<Book>> createUpdateBookCommand(Long id, Book book) {
        return new UpdateBookCommand(booksService, id, book);
    }

    public Command<Boolean> createDeleteBookCommand(Long id) {
        return new DeleteBookCommand(booksService, id);
    }
}