package com.hendro.alterra.service;

import com.hendro.alterra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class TestCoba {

    @Autowired
    ProductRepository productRepository;

    public List<Object> get() {
        return Collections.singletonList(productRepository.findAll());
    }

    public Integer add(Integer a, Integer b) {
        return a+b;
    }
}
