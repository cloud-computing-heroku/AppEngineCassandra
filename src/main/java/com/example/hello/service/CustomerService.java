package com.example.hello.service;

import com.example.hello.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomer();

    List<Customer> searchCustomer(String id, String name);

    void saveCustomer(Customer customer);

    Customer getCustomerByFullname(String name);

    Customer getCustomerByPhone(String phone);

    Customer getCustomerByMail(String mail);

    Customer getCustomerById(UUID id);

    boolean deleteCustomerById(UUID uuid);

    boolean isCustomerExist(Customer customer);

}
