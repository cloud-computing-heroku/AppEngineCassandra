package com.example.hello.repository;

import com.example.hello.model.ProductDetails;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductDetailsRepository extends CassandraRepository<ProductDetails, UUID> {
}
