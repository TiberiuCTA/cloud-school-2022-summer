package com.example.myfirst.repository;

import com.example.myfirst.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, Integer> {
    public void delete(Product product);
}
