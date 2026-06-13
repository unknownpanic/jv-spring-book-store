package com.bookstore.onlinebookstore.service.impl;

import com.bookstore.onlinebookstore.exception.RegistrationException;
import com.bookstore.onlinebookstore.mapper.UserMapper;
import com.bookstore.onlinebookstore.model.User;
import com.bookstore.onlinebookstore.model.dto.user.UserRegistrationRequestDto;
import com.bookstore.onlinebookstore.model.dto.user.UserResponseDto;
import com.bookstore.onlinebookstore.repository.user.UserRepository;
import com.bookstore.onlinebookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new RegistrationException("An account already exists with this email.");
        }
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        if (requestDto.getShippingAddress() != null) {
            user.setShippingAddress(requestDto.getShippingAddress());
        }
        User savedUser = userRepository.save(user);
        return userMapper.toUserResponse(savedUser);
    }
}
