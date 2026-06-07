package com.bookstore.onlinebookstore.repository.book;

import com.bookstore.onlinebookstore.model.Book;
import com.bookstore.onlinebookstore.repository.SpecificationProvider;
import com.bookstore.onlinebookstore.repository.SpecificationProviderManager;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    public SpecificationProvider<Book> getSpecificationProviderByAttribute(String attribute) {
        return bookSpecificationProviders.stream()
                .filter(p -> p.getAttribute().equals(attribute))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "No relevant specification provider has been found."));
    }
}
