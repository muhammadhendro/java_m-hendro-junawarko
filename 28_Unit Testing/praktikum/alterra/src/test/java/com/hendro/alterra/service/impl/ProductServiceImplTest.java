package com.hendro.alterra.service.impl;


import com.hendro.alterra.controller.ProductController;
import com.hendro.alterra.repository.ProductRepository;
import com.hendro.alterra.service.Product2Service;
import com.hendro.alterra.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataMongoTest
class ProductServiceImplTest {

    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void getAllProduct() {
    productService = new ProductServiceImpl();

        ResponseEntity<Object> result = productService.getAllProduct();
        
    }


}