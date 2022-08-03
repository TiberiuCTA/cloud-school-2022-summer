package com.example.myfirst.service;

import com.example.myfirst.model.Product;
import com.example.myfirst.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> aux = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Product getById(Integer id) {
        Product product = null;

        try {
            if (productRepository.findById(id).isPresent())
                product = productRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public void insert(Product product) {
        productRepository.save(product);
    }

    public void update(Product newProduct, Integer id) {

        productRepository.findById(id).map(product -> {
            if (newProduct.getName() != null)
                product.setName(newProduct.getName());
            if (newProduct.getPrice() != null)
                product.setPrice(newProduct.getPrice());
            return productRepository.save(product);
        });
    }
}
