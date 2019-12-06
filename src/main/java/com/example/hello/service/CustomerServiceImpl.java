package com.example.hello.service;

import com.example.hello.model.Customer;
import com.example.hello.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();
    }

    @Override
    public List<Customer> searchCustomer(String id, String name) {
//        return this.customerRepository.findCustomerByIdContainingAndFullnameContaining(id, name);
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByFullname(String name) {
        return this.customerRepository. findCustomerByFullname(name);
    }

    @Override
    public Customer getCustomerByPhone(String phone) {
        return this.customerRepository.findCustomerByPhone(phone);
    }

    @Override
    public Customer getCustomerByMail(String mail) {
        return this.customerRepository.findCustomerByMail(mail);
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return this.customerRepository.findCustomerById(id);
    }

    @Override
    public boolean deleteCustomerById(UUID uuid) {
        return this.customerRepository.deleteCustomerById(uuid);
    }

    @Override
    public boolean isCustomerExist(Customer customer) {
        Customer cus = this.customerRepository.findCustomerByPhone(customer.getPhone());
        if (cus != null) {
            return true;
        }
        return false;
    }
}
