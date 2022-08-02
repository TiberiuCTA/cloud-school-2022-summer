package com.example.myfirst.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/api/hello")
    public String sayHello(@RequestBody String name){
        return "Hello";
    }
}
