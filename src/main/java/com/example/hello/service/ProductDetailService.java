package com.example.hello.service;

import com.example.hello.model.ProductDetails;

import java.util.Optional;
import java.util.UUID;

public interface ProductDetailService {

    Optional<ProductDetails> getProductDetails(UUID id);

    void saveProductDetails(ProductDetails productDetails);

    void deleteProductDetails(UUID uuid);

}
