package com.bookstore.onlinebookstore.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "User login request")
public class UserLoginRequestDto {
    @Schema(
            description = "User email",
            example = "john.doe@gmail.com"
    )
    @NotBlank
    @Email
    private String email;

    @Schema(
            description = "User password",
            example = "password123"
    )
    @NotBlank
    private String password;
}
