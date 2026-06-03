package com.bookstore.onlinebookstore.mapper;

import com.bookstore.onlinebookstore.config.MapperConfig;
import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.model.dto.BookDto;
import com.bookstore.onlinebookstore.model.dto.CreateBookRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto bookDto);

    BookDto toDto(Book book);
}
