package com.example.hello.repository;

import com.example.hello.model.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, UUID> {

}
