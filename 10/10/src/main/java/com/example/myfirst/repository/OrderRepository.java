package com.example.myfirst.repository;

import com.example.myfirst.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    public List<Orders> findAll();
}
