package com.bookstore.onlinebookstore.service.impl;

import com.bookstore.onlinebookstore.exception.RegistrationException;
import com.bookstore.onlinebookstore.mapper.UserMapper;
import com.bookstore.onlinebookstore.model.Role;
import com.bookstore.onlinebookstore.model.Role.RoleName;
import com.bookstore.onlinebookstore.model.User;
import com.bookstore.onlinebookstore.model.dto.user.UserRegistrationRequestDto;
import com.bookstore.onlinebookstore.model.dto.user.UserResponseDto;
import com.bookstore.onlinebookstore.repository.role.RoleRepository;
import com.bookstore.onlinebookstore.repository.user.UserRepository;
import com.bookstore.onlinebookstore.service.UserService;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        String email = requestDto.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new RegistrationException("An account already exists with this email: " + email);
        }
        User user = userMapper.toModel(requestDto);
        Role userRole = roleRepository.findByName(RoleName.USER).orElseThrow(
                () -> new RegistrationException("Can't find user role object."));
        user.setRoles(Set.of(userRole));
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }
}
