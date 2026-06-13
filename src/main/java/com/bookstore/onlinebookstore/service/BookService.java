package com.bookstore.onlinebookstore.service;

import com.bookstore.onlinebookstore.model.dto.book.BookResponseDto;
import com.bookstore.onlinebookstore.model.dto.book.BookSearchParametersDto;
import com.bookstore.onlinebookstore.model.dto.book.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<BookResponseDto> getAll(Pageable pageable);

    BookResponseDto getBookById(Long id);

    BookResponseDto createBook(CreateBookRequestDto bookDto);

    BookResponseDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto);

    void deleteBookById(Long id);

    List<BookResponseDto> searchBooksByParameters(BookSearchParametersDto bookSearchParametersDto);
}
