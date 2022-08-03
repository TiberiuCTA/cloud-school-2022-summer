package com.example.myfirst.repository;

import com.example.myfirst.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    List<Orders> findAll();
}
