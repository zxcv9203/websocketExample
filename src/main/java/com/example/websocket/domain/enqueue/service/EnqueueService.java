package com.example.websocket.domain.enqueue.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnqueueService {

    private final JmsTemplate jmsTemplate;

    private final ObjectMapper objectMapper;

    @Value("${queue.test.destination}")
    private String queue;

    public void hello() {
        // ! JMS 직렬화/역직렬화 실패 문제 해결하기 org.apache.activemq.SERIALIZABLE_PACKAGES
//        Example example = Example.builder()
//            .id(1L)
//            .message("hello")
//            .price(BigDecimal.ONE)
//            .createdAt(LocalDateTime.now())
//            .build();
        jmsTemplate.convertAndSend(queue, "example");
    }
}
