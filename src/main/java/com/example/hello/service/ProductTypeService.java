package com.example.hello.service;

import com.example.hello.model.ProductType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductTypeService {
    List<ProductType> getAllProductType();

    List<ProductType> getAllProductTypeName();

    Optional<ProductType> getProductType(UUID id);

    void saveProductType(ProductType productType);

    void deleteProductType(UUID id);
}
