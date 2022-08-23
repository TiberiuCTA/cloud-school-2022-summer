package com.example.db12.controller;


import com.example.db12.model.Student;
import com.example.db12.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentRestController {
    private final StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
}