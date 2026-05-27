package com.bookstore.onlinebookstore.service;

import com.bookstore.onlinebookstore.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
