package com.bookstore.onlinebookstore.service;

import com.bookstore.onlinebookstore.exception.RegistrationException;
import com.bookstore.onlinebookstore.model.dto.user.UserRegistrationRequestDto;
import com.bookstore.onlinebookstore.model.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException;
}
