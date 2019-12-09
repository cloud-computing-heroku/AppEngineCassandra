package com.example.hello.service;

import com.example.hello.model.ProductDetails;

import java.util.Optional;
import java.util.UUID;

public interface ProductDetailService {

    Optional<ProductDetails> getProductDetails(String id);

    void saveProductDetails(ProductDetails productDetails);

    void deleteProductDetails(String uuid);

}
