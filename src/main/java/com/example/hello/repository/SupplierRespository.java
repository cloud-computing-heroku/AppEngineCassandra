package com.example.hello.repository;

import com.example.hello.model.Supplier;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SupplierRespository extends CassandraRepository<Supplier, UUID> {
    @Query("select name from supplier")
    List<Supplier> getSupplierNameAll();
}
