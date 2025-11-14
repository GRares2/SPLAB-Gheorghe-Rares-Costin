package com.example.lab1.commands;

import com.example.lab1.services.BooksService;

class DeleteBookCommand implements Command<Boolean> {
    private final BooksService booksService;
    private final Long bookId;

    public DeleteBookCommand(BooksService booksService, Long bookId) {
        this.booksService = booksService;
        this.bookId = bookId;
    }

    @Override
    public Boolean execute() {
        System.out.println("Executing DeleteBookCommand for id: " + bookId);
        return booksService.deleteBook(bookId);
    }
}