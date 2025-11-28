package com.example.lab1.services;

import com.example.lab1.models.Book;
import com.example.lab1.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    // GET all books
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    // GET book by ID
    public Optional<Book> getBookById(Long id) {
        return booksRepository.findById(id);
    }

    // POST - create new book
    public Book createBook(Book book) {
        return booksRepository.save(book);
    }

    // PUT - update book
    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return booksRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setTitle(updatedBook.getTitle());
                    existingBook.setAuthors(updatedBook.getAuthors());
                    existingBook.setTableOfContents(updatedBook.getTableOfContents());
                    return booksRepository.save(existingBook);
                });
    }

    // DELETE book
    public boolean deleteBook(Long id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return true;
        }
        return false;
    }
}