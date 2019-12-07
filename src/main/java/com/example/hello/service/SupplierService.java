package com.example.hello.service;

import com.example.hello.model.Employee;
import com.example.hello.model.Supplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplierService {
    List<Supplier> getAllSupplier();

    Optional<Supplier> getSupplier(UUID id);

    void saveSupplier(Supplier supplier);

    void deleteSupplier(UUID id);
}
