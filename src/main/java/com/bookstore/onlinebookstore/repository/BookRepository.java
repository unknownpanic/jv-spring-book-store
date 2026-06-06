package com.bookstore.onlinebookstore.repository;

import com.bookstore.onlinebookstore.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);

    void deleteById(Long id);
}
