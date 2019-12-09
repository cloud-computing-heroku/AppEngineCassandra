package com.example.hello.service;

import com.example.hello.model.Employee;
import com.example.hello.model.Supplier;
import com.example.hello.repository.SupplierRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRespository supplierRespository;

    @Override
    public List<Supplier> getAllSupplier() {
        return this.supplierRespository.findAll();
    }

    @Override
    public List<Supplier> getAllSupplierName() {
        return this.supplierRespository.getSupplierNameAll();
    }

    @Override
    public Optional<Supplier> getSupplier(UUID id) {
        return this.supplierRespository.findById(id);
    }

    @Override
    public void saveSupplier(Supplier supplier) {
        this.supplierRespository.save(supplier);
    }

    @Override
    public void deleteSupplier(UUID id) {
        this.supplierRespository.deleteById(id);
    }
}
