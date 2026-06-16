package com.bookstore.onlinebookstore.model.dto.user;

import com.bookstore.onlinebookstore.validation.annotation.FieldsMatch;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "User registration request")
@FieldsMatch(
        field = "password",
        matchField = "repeatPassword",
        message = "Passwords don't match. Please re-enter your password."
)
public class UserRegistrationRequestDto {
    @NotBlank
    @Email
    @Schema(
            description = "User email address",
            example = "john.doe@gmail.com"
    )
    private String email;

    @NotBlank
    @Schema(
            description = "User password",
            example = "StrongPassword123"
    )
    private String password;

    @NotBlank
    @Schema(
            description = "Repeated password for confirmation",
            example = "StrongPassword123"
    )
    private String repeatPassword;

    @NotBlank
    @Schema(
            description = "User first name",
            example = "John"
    )
    private String firstName;

    @NotBlank
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
