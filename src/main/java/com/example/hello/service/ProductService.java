package com.example.hello.service;

import com.example.hello.model.Product;
import com.example.hello.model.ProductDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    List<Product> getAllProduct();

    List<Product> getProductByProducerName(String name);

    Optional<Product> getProduct(UUID id);

    void saveProduct(Product product);

    void deleteProduct(UUID id);
}
