package com.bookstore.onlinebookstore.repository;

import org.springframework.stereotype.Component;

@Component
public interface SpecificationProviderManager<T> {
    SpecificationProvider<T> getSpecificationProviderByAttribute(String attribute);
}
