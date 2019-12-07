package com.example.hello.service;

import com.example.hello.model.OrderDetails;
import com.example.hello.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Optional<OrderDetails> getOrderDetails(UUID id) {
        return this.orderDetailRepository.findById(id);
    }

    @Override
    public void saveOrderDetails(OrderDetails orderDetails) {
        this.orderDetailRepository.save(orderDetails);
    }

    @Override
    public void deleteOrderDetails(UUID id) {
        this.orderDetailRepository.deleteById(id);
    }
}
