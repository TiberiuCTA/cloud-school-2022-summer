package com.example.db22.controller;

import com.example.db22.model.User;
import com.example.db22.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;


    @GetMapping("get/{name}")
    public List<User> getByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @PostMapping()
    public User insert(@RequestBody User user){
        return userService.save(user);
    }

}
