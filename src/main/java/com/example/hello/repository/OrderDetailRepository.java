package com.example.hello.repository;

import com.example.hello.model.OrderDetails;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface OrderDetailRepository extends CassandraRepository<OrderDetails, UUID> {
}
