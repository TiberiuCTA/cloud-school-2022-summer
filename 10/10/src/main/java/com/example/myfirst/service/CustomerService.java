package com.example.myfirst.service;

import com.example.myfirst.model.Customer;
import com.example.myfirst.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        List<Customer> aux = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Customer getById(Integer id) {
        Customer customer = null;

        try {
            if (customerRepository.findById(id).isPresent())
                customer = customerRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    public void insert(Customer customer) {
        customerRepository.save(customer);
    }

    public void update(Customer newCustomer, Integer id) {

        customerRepository.findById(id).map(customer -> {
            if (newCustomer.getName() != null)
                customer.setName(newCustomer.getName());
            if (newCustomer.getEmail() != null)
                customer.setEmail(newCustomer.getEmail());
            return customerRepository.save(customer);
        });
    }
}
