package com.example.websocket.domain.enqueue.controller;

import com.example.websocket.domain.enqueue.service.EnqueueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class EnqueueController {

    private final EnqueueService enqueueService;

    @PostMapping("/hello")
    public ResponseEntity<Void> helloMessage() {
        enqueueService.hello();
        log.info("message Enqueue");
        return ResponseEntity.noContent().build();
    }
}
