package com.example.lab1.services;

import com.example.lab1.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BooksService {
    private final Map<Long, Book> books = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    // GET all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    // GET book by ID
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    // POST - create new book
    public Book createBook(Book book) {
        Long id = idCounter.incrementAndGet();
        book.setId(id);
        books.put(id, book);
        return book;
    }

    // PUT - update book
    public Optional<Book> updateBook(Long id, Book updatedBook) {
        if (books.containsKey(id)) {
            updatedBook.setId(id);
            books.put(id, updatedBook);
            return Optional.of(updatedBook);
        }
        return Optional.empty();
    }

    // DELETE book
    public boolean deleteBook(Long id) {
        return books.remove(id) != null;
    }
}