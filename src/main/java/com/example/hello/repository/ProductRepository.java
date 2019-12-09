package com.example.hello.repository;

import com.example.hello.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
    List<Product> findProductByProducerName(String productname);
}
