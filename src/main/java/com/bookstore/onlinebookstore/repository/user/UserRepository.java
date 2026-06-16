package com.bookstore.onlinebookstore.repository.user;

import com.bookstore.onlinebookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
