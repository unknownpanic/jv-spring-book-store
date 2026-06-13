package com.bookstore.onlinebookstore.model.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatedPassword;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String shippingAddress;
}
