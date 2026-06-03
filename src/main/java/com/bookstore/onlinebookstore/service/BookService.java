package com.bookstore.onlinebookstore.service;

import com.bookstore.onlinebookstore.model.dto.BookDto;
import com.bookstore.onlinebookstore.model.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    List<BookDto> getAll();

    BookDto getBookById(Long id);

    BookDto createBook(CreateBookRequestDto bookDto);
}
