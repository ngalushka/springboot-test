package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    private static final Logger logger = LoggerFactory.getLogger(EventsController.class);

    @PostMapping("/event")
    public String receiveEvent(@RequestBody Event event) {
        logger.info("Received event: {}", event);
        return "Event received successfully!";
    }
}
