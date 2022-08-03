package com.example.myfirst.controller;

import com.example.myfirst.model.Product;
import com.example.myfirst.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @PostMapping()
    public void insert(@RequestBody Product order) {
        productService.insert(order);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Product order, @PathVariable Integer id) {
        productService.update(order, id);
    }
}
