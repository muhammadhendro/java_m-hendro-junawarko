package com.hendro25.alterra.util;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.hendro25.alterra.model.base.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    private ResponseUtil(){}

    public static ResponseEntity<Object> build(String responseCode, String message, Object data, HttpStatus httpStatus) {
            return new ResponseEntity<>(build(responseCode, message, data), httpStatus);
    }

    private static BaseResponse build(String responseCode, String message, Object data) {
        return BaseResponse.builder()
                .timestamp(LocalDateTime.now())
                .responseCode(responseCode)
                .message(message)
                .data(data)
                .build();
    }

//    public static ResponseEntity<Object> build(Object data, String code, HttpStatus httpStatus) {
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("timestamp", LocalDateTime.now());
//        map.put("response_code", httpStatus.value());
//        map.put("message", code);
//        map.put("data", data);
//
//        return new ResponseEntity<>(map, httpStatus);
//    }
}
