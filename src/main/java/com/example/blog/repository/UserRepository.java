package com.example.blog.repository;

import com.example.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query methods can be defined here if needed
    // For example, to find a user by username:
    // Optional<User> findByUsername(String username);

    // Or to find users by role:
    // List<User> findByRole(Role role);
}
