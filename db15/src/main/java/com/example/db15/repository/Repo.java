package com.example.db15.repository;

import com.example.db15.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Car, Integer> {

}
