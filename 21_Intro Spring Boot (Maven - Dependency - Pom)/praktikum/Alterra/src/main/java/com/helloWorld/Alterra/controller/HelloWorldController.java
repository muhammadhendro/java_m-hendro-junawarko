package com.helloWorld.Alterra.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @GetMapping("/messages")
    public String getMessage() {
        return "Hello World";
    }

    @PostMapping("/messages")
    public String postMessage() {
        return "Hello World";
    }

    @DeleteMapping("/messages")
    public String deleteMessage() {
        return "Hello World";
    }
}
