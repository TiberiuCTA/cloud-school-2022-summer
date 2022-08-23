package com.example.db22.service;

import com.example.db22.model.User;
import com.example.db22.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUserByName(String name){
       return userRepository.findAllByName(name);
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
