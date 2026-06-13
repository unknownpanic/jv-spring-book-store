package com.bookstore.onlinebookstore.service.impl;

import com.bookstore.onlinebookstore.exception.EntityNotFoundException;
import com.bookstore.onlinebookstore.mapper.BookMapper;
import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.model.dto.book.BookResponseDto;
import com.bookstore.onlinebookstore.model.dto.book.BookSearchParametersDto;
import com.bookstore.onlinebookstore.model.dto.book.CreateBookRequestDto;
import com.bookstore.onlinebookstore.repository.book.BookRepository;
import com.bookstore.onlinebookstore.repository.book.BookSpecificationBuilder;
import com.bookstore.onlinebookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookSpecificationBuilder bookSpecificationBuilder;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Page<BookResponseDto> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toDto);
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book with id: " + id)));
    }

    @Override
    public List<BookResponseDto> searchBooksByParameters(BookSearchParametersDto bookSearchParametersDto) {
        Specification<Book> specification = bookSpecificationBuilder.build(bookSearchParametersDto);
        return bookRepository.findAll(specification).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public BookResponseDto createBook(CreateBookRequestDto bookDto) {
        Book bookModel = bookMapper.toModel(bookDto);
        return bookMapper.toDto(bookRepository.save(bookModel));
    }

    @Override
    @Transactional
    public BookResponseDto updateBookById(Long id, CreateBookRequestDto bookDto) {
        Book existingBook = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book with id: " + id));
        bookMapper.updateBook(existingBook, bookDto);
        return bookMapper.toDto(bookRepository.save(existingBook));
    }

    @Override
    @Transactional
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
