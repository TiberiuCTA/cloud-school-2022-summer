package com.example.db13.controller;


import com.example.db13.model.Product;
import com.example.db13.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ThyController {
    private final ProductService productService;

    @GetMapping("product")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }
}
