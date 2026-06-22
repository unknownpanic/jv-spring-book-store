package com.bookstore.onlinebookstore.model.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "JWT authentication response")
public class UserLoginResponseDto {
    @Schema(
            description = "JWT access token",
            example = "eyJhbGciOiJIUzI1NiJ9..."
    )
    private String token;
}
