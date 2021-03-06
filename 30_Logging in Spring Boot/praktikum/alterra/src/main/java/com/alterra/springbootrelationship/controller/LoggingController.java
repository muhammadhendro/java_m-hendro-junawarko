package com.alterra.springbootrelationship.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("A INFO Message");
        logger.warn("A WARN Message");
        logger.error("A ERROR Message");

        return "Howdy! Check out the logs to see the output...";
    }
}
