package com.bookstore.onlinebookstore.controller;

import com.bookstore.onlinebookstore.exception.RegistrationException;
import com.bookstore.onlinebookstore.model.dto.user.UserRegistrationRequestDto;
import com.bookstore.onlinebookstore.model.dto.user.UserResponseDto;
import com.bookstore.onlinebookstore.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication", description = "Endpoints for user authentication")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;

    @Operation(
            summary = "Register a new user",
            description = "Creates a new user account in the system"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "User successfully registered"),
            @ApiResponse(responseCode = "400",
                    description = "Validation failed")
    })
    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }
}
