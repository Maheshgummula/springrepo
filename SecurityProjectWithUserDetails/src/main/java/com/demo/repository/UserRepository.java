package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
Optional<User> findByName(String name);
}
