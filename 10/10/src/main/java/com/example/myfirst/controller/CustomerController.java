package com.example.myfirst.controller;

import com.example.myfirst.model.Customer;
import com.example.myfirst.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable Integer id) {
        return customerService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        customerService.deleteById(id);
    }

    @PostMapping()
    public void insert(@RequestBody Customer customer) {
        customerService.insert(customer);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Customer customer, @PathVariable Integer id) {
        customerService.update(customer, id);
    }
}
