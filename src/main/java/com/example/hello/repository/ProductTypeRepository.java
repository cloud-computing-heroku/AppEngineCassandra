package com.example.hello.repository;

import com.example.hello.model.ProductType;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductTypeRepository extends CassandraRepository<ProductType, UUID> {
    @Query("select name from product_type")
    List<ProductType> findProductTypeNameAll();
}
