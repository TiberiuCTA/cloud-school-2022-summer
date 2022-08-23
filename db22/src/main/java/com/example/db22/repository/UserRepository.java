package com.example.db22.repository;

import com.example.db22.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByName(String name);
}
