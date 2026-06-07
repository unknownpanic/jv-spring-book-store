package com.bookstore.onlinebookstore.repository.book;

import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.model.dto.BookSearchParametersDto;
import com.bookstore.onlinebookstore.repository.SpecificationBuilder;
import com.bookstore.onlinebookstore.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder
        implements SpecificationBuilder<Book, BookSearchParametersDto> {
    private final SpecificationProviderManager<Book> specificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        Specification<Book> customSpecification = Specification.unrestricted();

        if (searchParameters.getAuthors() != null && searchParameters.getAuthors().length > 0) {
            customSpecification = customSpecification.and(specificationProviderManager
                    .getSpecificationProviderByAttribute("author")
                            .getSpecification(searchParameters.getAuthors()));
        }

        return customSpecification;
    }
}
