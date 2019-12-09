package com.example.hello.service;

import com.example.hello.model.ProductDetails;
import com.example.hello.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    protected ProductDetailsRepository productDetailsRepository;

    @Override
    public Optional<ProductDetails> getProductDetails(String id) {
        return this.productDetailsRepository.findById(id);
    }

    @Override
    public void saveProductDetails(ProductDetails productDetails) {
        this.productDetailsRepository.save(productDetails);
    }

    @Override
    public void deleteProductDetails(String uuid) {
        this.productDetailsRepository.deleteById(uuid);
    }
}
