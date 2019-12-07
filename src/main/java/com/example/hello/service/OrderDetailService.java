package com.example.hello.service;

import com.example.hello.model.OrderDetails;

import java.util.Optional;
import java.util.UUID;

public interface OrderDetailService {
    Optional<OrderDetails> getOrderDetails(UUID id);

    void saveOrderDetails(OrderDetails orderDetails);

    void deleteOrderDetails(UUID id);
}
