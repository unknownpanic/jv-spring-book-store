package com.bookstore.onlinebookstore.service.impl;

import com.bookstore.onlinebookstore.exception.EntityNotFoundException;
import com.bookstore.onlinebookstore.mapper.BookMapper;
import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.model.dto.BookDto;
import com.bookstore.onlinebookstore.model.dto.CreateBookRequestDto;
import com.bookstore.onlinebookstore.repository.BookRepository;
import com.bookstore.onlinebookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book with id: " + id)));
    }

    @Override
    public BookDto createBook(CreateBookRequestDto bookDto) {
        Book bookModel = bookMapper.toModel(bookDto);
        return bookMapper.toDto(bookRepository.save(bookModel));
    }
}
