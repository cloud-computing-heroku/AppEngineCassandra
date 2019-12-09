package com.example.hello.service;

import com.example.hello.model.Product;
import com.example.hello.model.ProductDetails;
import com.example.hello.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public List<Product> getProductByProducerName(String name) {
        return this.productRepository.findProductByProducerName(name);
    }

    @Override
    public Optional<Product> getProduct(UUID id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        this.productRepository.deleteById(id);
    }
}
