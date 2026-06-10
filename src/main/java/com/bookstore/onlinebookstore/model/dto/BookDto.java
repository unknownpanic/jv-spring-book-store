package com.bookstore.onlinebookstore.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Book response object")
public class BookDto {
    @Schema(description = "Unique book identifier", example = "1")
    private Long id;

    @Schema(description = "Book title", example = "Clean Code")
    private String title;

    @Schema(description = "Book author", example = "Robert C. Martin")
    private String author;

    @Schema(description = "International Standard Book Number", example = "9780132350884")
    private String isbn;

    @Schema(description = "Book price", example = "39.99")
    private BigDecimal price;

    @Schema(
            description = "Short book description",
            example = "A handbook of agile software craftsmanship."
    )
    private String description;

    @Schema(
            description = "URL of the book cover image",
            example = "https://example.com/images/clean-code.jpg"
    )
    private String coverImage;
}
