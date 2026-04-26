package com.example.demo1.controllers;

import com.example.demo1.dto.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BooksController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("books")
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("books2")
    public Set<Book> getBooksDistinct() {
        return new HashSet<>(books);
    }

    @PostMapping("books")
    public void addBook(@RequestBody Book book) {
        books.add(book);
    }
}
