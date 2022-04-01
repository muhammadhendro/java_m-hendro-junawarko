package com.hendro.alterra.service;

import com.hendro.alterra.controller.ProductController;
import com.hendro.alterra.domain.dao.ProductDao;
import com.hendro.alterra.repository.ProductRepository;
import lombok.Data;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class TestCobaTest {

    private TestCoba testCoba = new TestCoba();


//    @Autowired
//    private MockMvc mvc;

    @MockBean
    private ProductRepository productRepository;




    @Test
    void add() {
        Integer result = testCoba.add(1,1);
        assertEquals(2, result);
    }




}