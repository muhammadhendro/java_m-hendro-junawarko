package com.hendro.alterra.controller;

import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.domain.dto.ProductDto;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger.readers.operation.SwaggerOperationTagsReader;

import java.awt.*;

@RestController
@RequestMapping(value = "/v1/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() {
        return productService.getAllProduct();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto request) {
        return productService.saveProduct(request);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping(value= "/{id}")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody ProductDto request) {
        return productService.updateProductById(id, request);
    }



}
