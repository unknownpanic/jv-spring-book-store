package com.bookstore.onlinebookstore.model.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSearchParametersDto {
    private List<String> authors = new ArrayList<>();
}
