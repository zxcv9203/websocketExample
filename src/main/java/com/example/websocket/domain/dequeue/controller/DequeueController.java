package com.example.websocket.domain.dequeue.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DequeueController {

    @JmsListener(destination = "${queue.test.destination}")
    public void consumeMessage(String example) {
        log.info("message : {}", example);
    }
}
