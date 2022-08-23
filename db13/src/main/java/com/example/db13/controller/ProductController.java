package com.example.db13.controller;


import com.example.db13.model.Product;
import com.example.db13.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer id){
        return productService.updateProduct(product, id);
    }
}
