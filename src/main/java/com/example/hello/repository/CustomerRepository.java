package com.example.hello.repository;

import com.example.hello.model.Customer;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CassandraRepository<Customer, UUID> {
    Customer findCustomerByPhone(String phone);

    Customer findCustomerByMail(String mail);

    Customer findCustomerByFullname(String fullname);

//    List<Customer> findCustomerByIdContainingAndFullnameContaining(String id, String name);

    boolean deleteCustomerById(UUID uuid);

    Customer findCustomerById(UUID uuid);
}
