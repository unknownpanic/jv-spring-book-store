package com.bookstore.onlinebookstore.controller;

import com.bookstore.onlinebookstore.model.dto.book.BookResponseDto;
import com.bookstore.onlinebookstore.model.dto.book.BookSearchParametersDto;
import com.bookstore.onlinebookstore.model.dto.book.CreateBookRequestDto;
import com.bookstore.onlinebookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book management", description = "Endpoints for managing books")
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Operation(
            summary = "Get all books",
            description = "Returns a paginated list of all available books. "
                    + "Available for USER and ADMIN roles"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Books retrieved successfully")
    })
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping
    public Page<BookResponseDto> getAll(
            @Parameter(description = "Pagination and sorting parameters")
            @PageableDefault(size = 15, sort = "title") Pageable pageable
    ) {
        return bookService.getAll(pageable);
    }

    @Operation(
            summary = "Get book by ID",
            description = "Returns a book by its identifier. Available for USER and ADMIN roles"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book found"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/{id}")
    public BookResponseDto getBookById(
            @Parameter(description = "Book ID", example = "1")
            @PathVariable Long id
    ) {
        return bookService.getBookById(id);
    }

    @Operation(
            summary = "Search books",
            description = "Search books using author filter. Available for USER and ADMIN roles"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Search completed successfully")
    })
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/search")
    public List<BookResponseDto> searchBooks(
            @Parameter(description = "Search parameters")
            BookSearchParametersDto searchParametersDto
    ) {
        return bookService.searchBooksByParameters(searchParametersDto);
    }

    @Operation(
            summary = "Create a new book",
            description = "Creates a new book and returns created entity. ADMIN role required"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Book created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request data"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "User with this email already exists"
            )
    })
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto createBook(@RequestBody @Valid CreateBookRequestDto requestDto) {
        return bookService.createBook(requestDto);
    }

    @Operation(
            summary = "Update book",
            description = "Updates an existing book by ID.  ADMIN role required"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Book updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public BookResponseDto updateBookById(
            @Parameter(description = "Book ID", example = "1")
            @PathVariable Long id,
            @RequestBody @Valid CreateBookRequestDto requestDto
    ) {
        return bookService.updateBookById(id, requestDto);
    }

    @Operation(
            summary = "Delete book",
            description = "Deletes a book by its ID. ADMIN role required"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found")
    })
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(
            @Parameter(description = "Book ID", example = "1")
            @PathVariable Long id
    ) {
        bookService.deleteBookById(id);
    }
}
