package com.bookstore.onlinebookstore.repository;

import com.bookstore.onlinebookstore.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);
}
