package com.example.hello.service;

import com.example.hello.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<Order> getAllOrder();

    Optional<Order> getOrder(UUID id);

    void saveOrder(Order order);

    void deleteOrder(UUID id);
}
