package com.bookstore.onlinebookstore.service;

import com.bookstore.onlinebookstore.model.dto.book.BookDto;
import com.bookstore.onlinebookstore.model.dto.book.BookSearchParametersDto;
import com.bookstore.onlinebookstore.model.dto.book.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<BookDto> getAll(Pageable pageable);

    BookDto getBookById(Long id);

    BookDto createBook(CreateBookRequestDto bookDto);

    BookDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto);

    void deleteBookById(Long id);

    List<BookDto> searchBooksByParameters(BookSearchParametersDto bookSearchParametersDto);
}
