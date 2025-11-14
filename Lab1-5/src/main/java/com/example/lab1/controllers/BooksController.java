package com.example.lab1.controllers;

import com.example.lab1.commands.Command;
import com.example.lab1.commands.CommandFactory;
import com.example.lab1.models.Book;
import com.example.lab1.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final CommandFactory commandFactory;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
        this.commandFactory = new CommandFactory(booksService);
    }

    // GET /books - Get all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        Command<List<Book>> command = commandFactory.createGetAllBooksCommand();
        List<Book> books = command.execute();
        return ResponseEntity.ok(books);
    }

    // GET /books/{id} - Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Command<Optional<Book>> command = commandFactory.createGetBookByIdCommand(id);
        Optional<Book> book = command.execute();

        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /books - Create new book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Command<Book> command = commandFactory.createCreateBookCommand(book);
        Book createdBook = command.execute();
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    // PUT /books/{id} - Update book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Command<Optional<Book>> command = commandFactory.createUpdateBookCommand(id, book);
        Optional<Book> updatedBook = command.execute();

        return updatedBook.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /books/{id} - Delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Command<Boolean> command = commandFactory.createDeleteBookCommand(id);
        boolean deleted = command.execute();

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}