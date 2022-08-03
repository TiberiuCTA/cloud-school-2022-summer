package com.example.myfirst.service;

import com.example.myfirst.model.Orders;
import com.example.myfirst.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Orders> getAllOrders() {
        List<Orders> aux = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Orders getById(Integer id) {
        Orders order = null;

        try {
            if (orderRepository.findById(id).isPresent())
                order = orderRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return order;
    }

    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    public void insert(Orders order) {
        orderRepository.save(order);
    }

    public void update(Orders newOrder, Integer id) {

        orderRepository.findById(id).map(order -> {
            if (newOrder.getStatus() != null)
                order.setStatus(newOrder.getStatus());
            if (newOrder.getComments() != null)
                order.setComments(newOrder.getComments());
            return orderRepository.save(order);
        });
    }
}
