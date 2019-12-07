package com.example.hello.service;

import com.example.hello.model.ProductType;
import com.example.hello.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAllProductType() {
        return this.productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> getProductType(UUID id) {
        return this.productTypeRepository.findById(id);
    }

    @Override
    public void saveProductType(ProductType productType) {
        this.productTypeRepository.save(productType);
    }

    @Override
    public void deleteProductType(UUID id) {
        this.productTypeRepository.deleteById(id);
    }
}
