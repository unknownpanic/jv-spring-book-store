package com.bookstore.onlinebookstore.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationProvider<T> {
    String getAttribute();

    default Specification<T> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> {
            CriteriaBuilder.In<String> inPredicate = criteriaBuilder.in(root.get(getAttribute()));
            Arrays.asList(params).forEach(inPredicate::value);
            return criteriaBuilder.and(inPredicate);
        };
    }
}
