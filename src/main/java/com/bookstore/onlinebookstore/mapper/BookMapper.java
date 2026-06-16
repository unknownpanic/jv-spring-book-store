package com.bookstore.onlinebookstore.mapper;

import com.bookstore.onlinebookstore.config.MapperConfig;
import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.model.dto.book.BookResponseDto;
import com.bookstore.onlinebookstore.model.dto.book.CreateBookRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto bookDto);

    BookResponseDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    void updateBook(@MappingTarget Book existingBook, CreateBookRequestDto bookDto);
}
