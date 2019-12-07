package com.example.hello.service;

import com.example.hello.model.Employee;
import com.example.hello.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(UUID id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        this.employeeRepository.deleteById(id);
    }
}
