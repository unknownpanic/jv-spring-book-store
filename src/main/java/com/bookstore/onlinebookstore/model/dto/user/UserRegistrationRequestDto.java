package com.bookstore.onlinebookstore.model.dto.user;

import com.bookstore.onlinebookstore.validation.annotation.FieldsMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@FieldsMatch(field = "password", matchField = "repeatPassword",
        message = "Passwords don't match. Please re-enter your password.")
public class UserRegistrationRequestDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String shippingAddress;
}
