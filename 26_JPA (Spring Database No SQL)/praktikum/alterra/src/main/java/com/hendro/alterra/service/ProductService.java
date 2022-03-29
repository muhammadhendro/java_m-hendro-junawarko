package com.hendro.alterra.service;

import com.hendro.alterra.domain.dto.ProductDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {


    ResponseEntity<Object> getAllProduct();

    ResponseEntity<Object> getProductById(Long id);

    ResponseEntity<Object> saveProduct(ProductDto request);

    ResponseEntity<Object> deleteProduct(Long id);

    ResponseEntity<Object> updateProductById(Long id, ProductDto request);
}
