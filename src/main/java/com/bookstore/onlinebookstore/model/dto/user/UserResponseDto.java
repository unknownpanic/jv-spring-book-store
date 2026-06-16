package com.bookstore.onlinebookstore.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Registered user information")
public class UserResponseDto {
    @Schema(
            description = "User identifier",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "User email",
            example = "john.doe@gmail.com"
    )
    private String email;

    @Schema(
            description = "User first name",
            example = "John"
    )
    private String firstName;

    @Schema(
            description = "User last name",
            example = "Doe"
    )
    private String lastName;

    @Schema(
            description = "Shipping address",
            example = "123 Main Street, New York"
    )
    private String shippingAddress;
}
