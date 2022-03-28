package com.hendro25.alterra.service;

import com.hendro25.alterra.model.base.BaseResponse;
import com.hendro25.alterra.model.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.awt.print.Pageable;


public interface ProductService {

    ResponseEntity<Object> getAllProduct();

    ResponseEntity<Object> getProductById(Long id);

    ResponseEntity<Object> getAllProductByPage();

    ResponseEntity<Object> saveProduct(ProductDto request);

    ResponseEntity<Object> deleteProduct(Long id);

    ResponseEntity<Object> updateProductById(Long id, ProductDto request);

    ResponseEntity<Object> getAllProductByCategory();
}
