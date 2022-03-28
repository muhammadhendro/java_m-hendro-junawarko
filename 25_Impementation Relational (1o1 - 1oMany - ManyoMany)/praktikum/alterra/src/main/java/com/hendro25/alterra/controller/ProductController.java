package com.hendro25.alterra.controller;

import com.hendro25.alterra.model.dto.ProductDto;
import com.hendro25.alterra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

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
    public ResponseEntity<Object> getById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping(value = "/category")
    public ResponseEntity<Object> getAllByCategory() {
        return productService.getAllProductByCategory();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Object> getAllProductByPage() {
        return productService.getAllProductByPage();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveTransaction(@RequestBody ProductDto request) {
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
