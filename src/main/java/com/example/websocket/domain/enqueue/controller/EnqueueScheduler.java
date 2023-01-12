package com.example.websocket.domain.enqueue.controller;

import com.example.websocket.domain.enqueue.service.EnqueueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnqueueScheduler {

    private static final long SECONDS = 1000L;
    private final EnqueueService enqueueService;

    @Scheduled(fixedRate = SECONDS)
    public void helloMessage() {
        enqueueService.hello();
        log.info("message Enqueue");
    }
}
