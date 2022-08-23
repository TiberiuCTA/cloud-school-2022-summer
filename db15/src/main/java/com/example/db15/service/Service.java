package com.example.db15.service;

import com.example.db15.model.Car;
import com.example.db15.repository.Repo;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {
    final Repo repo;

    public Car getById(Integer id){
        return repo.findById(id).orElse(new Car());
    }

    public Car getByIdT(Integer id){
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }
}
