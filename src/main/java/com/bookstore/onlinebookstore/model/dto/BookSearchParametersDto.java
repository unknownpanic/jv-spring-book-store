package com.bookstore.onlinebookstore.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Book search parameters")
public class BookSearchParametersDto {
    @Schema(
            description = "List of authors to filter by",
            example = "F. Scott Fitzgerald"
    )
    private List<String> authors = new ArrayList<>();
}
