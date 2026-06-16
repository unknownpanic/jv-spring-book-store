package com.bookstore.onlinebookstore.model.dto.book;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Request object for creating or updating a book")
public class CreateBookRequestDto {
    @NotBlank
    @Schema(
            description = "Book title",
            example = "Clean Code",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String title;

    @NotBlank
    @Schema(
            description = "Book author",
            example = "Robert C. Martin",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String author;

    @NotBlank
    @Schema(
            description = "ISBN number",
            example = "9780132350884",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String isbn;

    @NotNull
    @PositiveOrZero
    @Schema(
            description = "Book price",
            example = "39.99",
            minimum = "0",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private BigDecimal price;

    @Schema(
            description = "Book description",
            example = "A handbook of agile software craftsmanship."
    )
    private String description;

    @Schema(
            description = "URL of the book cover image",
            example = "https://example.com/images/clean-code.jpg"
    )
    private String coverImage;
}
