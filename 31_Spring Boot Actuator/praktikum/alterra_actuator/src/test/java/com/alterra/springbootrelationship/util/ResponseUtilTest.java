package com.alterra.springbootrelationship.util;

import com.alterra.springbootrelationship.constant.AppConstant;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponseUtilTest {

    @Test
    void buildResponse_Success() {
        ResponseEntity<Object> responseEntity = ResponseUtil.build(AppConstant.ResponseCode.SUCCESS, null, HttpStatus.OK);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
    }

}