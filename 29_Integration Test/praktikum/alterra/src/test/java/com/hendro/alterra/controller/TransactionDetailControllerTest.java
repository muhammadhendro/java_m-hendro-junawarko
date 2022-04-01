package com.hendro.alterra.controller;

import com.hendro.alterra.repository.TransactionDetailRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TransactionDetailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionDetailRepository transactionDetailRepository;

    @MockBean TransactionDetailController transactionDetailController;


    @Test
    public void getAll() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/v1/transaction_detail")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        assertEquals(200, response.getResponse().getStatus());

    }

    @Test
    void saveNoPayload() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/transaction_detail")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        assertEquals(400, response.getResponse().getStatus());
    }

    @Test
    void saveWithpayload() throws Exception{
        JSONObject payload = new JSONObject();

        payload.put("transaction_id", "1");
        payload.put("product_id", "1");
        payload.put("quantity", "1");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/v1/transaction_detail")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload.toString())
                .accept(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        assertEquals(200, response.getResponse().getStatus());
    }
}