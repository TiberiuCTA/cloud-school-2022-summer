package com.example.myfirst.repository;

import com.example.myfirst.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Customer getById(String customerId);
}
