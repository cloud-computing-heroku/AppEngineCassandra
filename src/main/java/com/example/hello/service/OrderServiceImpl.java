package com.example.hello.service;

import com.example.hello.model.Order;
import com.example.hello.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrder(UUID id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public void saveOrder(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public void deleteOrder(UUID id) {
        this.orderRepository.deleteById(id);
    }
}
