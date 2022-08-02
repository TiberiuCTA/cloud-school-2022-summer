package com.spring.boot2.boot2proj.repository;

import com.spring.boot2.boot2proj.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findAll();
}
