package com.example.hello.repository;

import com.example.hello.model.Shiper;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShiperRepository extends CassandraRepository<Shiper, UUID> {
}
