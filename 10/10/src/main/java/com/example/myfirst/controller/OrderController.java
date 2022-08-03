package com.example.myfirst.controller;

import com.example.myfirst.model.Orders;
import com.example.myfirst.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("all")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("{id}")
    public Orders getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        orderService.deleteById(id);
    }

    @PostMapping()
    public void insert(@RequestBody Orders order) {
        orderService.insert(order);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Orders order, @PathVariable Integer id) {
        orderService.update(order, id);
    }
}
