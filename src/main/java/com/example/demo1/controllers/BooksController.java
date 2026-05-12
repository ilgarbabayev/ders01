package com.example.demo1.controllers;

import com.example.demo1.dto.Book;
import com.example.demo1.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/v1/books")
public class BooksController {

    private final List<Book> books = new ArrayList<>();

    @GetMapping
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("/distinct")
    public Set<Book> getBooksDistinct() {
        return new HashSet<>(books);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        books.add(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        Book existingBook = books.stream()
                .filter(b -> Objects.equals(b.getId(), book.getId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        final String newName = book.getName();
        final String newAuthor = book.getAuthor();

        existingBook.setName(newName);
        existingBook.setAuthor(newAuthor);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        books.removeIf(book -> book.getId().equals(bookId));
    }
}