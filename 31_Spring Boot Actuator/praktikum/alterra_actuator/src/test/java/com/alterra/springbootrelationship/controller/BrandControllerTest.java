package com.alterra.springbootrelationship.controller;

import com.alterra.springbootrelationship.constant.AppConstant;
import com.alterra.springbootrelationship.domain.dto.BrandDto;
import com.alterra.springbootrelationship.service.BrandService;
import com.alterra.springbootrelationship.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(SpringExtension.class) // JUnit 4 @RunWith(SpringRunner.class)
@SpringBootTest(classes = BrandController.class)
@EnableWebMvc
@AutoConfigureMockMvc
class BrandControllerTest {

    @MockBean
    private BrandService brandService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void createNewBrandSuccess_Test() throws Exception {
        when(brandService.addBrand(any()))
                .thenReturn(ResponseUtil.build(AppConstant.ResponseCode.SUCCESS,
                        BrandDto.builder().id(1L).brandName("New Brand").build(), HttpStatus.OK));
        this.mockMvc.perform(post("/v1/brand")
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{}"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void createNewBrandException_Test() {
        when(brandService.addBrand(any())).thenThrow(NullPointerException.class);

        Assertions.assertThrows(Exception.class, () -> this.mockMvc.perform(post("/v1/brand")
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{}"))
                .andReturn());
    }

}