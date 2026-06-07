package com.bookstore.onlinebookstore.repository.book.specification;

import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.repository.SpecificationProvider;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    private static final String AUTHOR_ATTRIBUTE = "author";

    @Override
    public String getAttribute() {
        return AUTHOR_ATTRIBUTE;
    }
}
