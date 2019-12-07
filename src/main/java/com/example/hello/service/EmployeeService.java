package com.example.hello.service;

import com.example.hello.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Optional<Employee> getEmployee(UUID id);

    void saveEmployee(Employee employee);

    void deleteEmployee(UUID id);
}
