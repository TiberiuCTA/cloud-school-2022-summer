package com.example.myfirst.controller;

import com.example.myfirst.model.Customer;
import com.example.myfirst.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
