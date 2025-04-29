package com.example.demo.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @KafkaListener(topics = "demo-events", groupId = "demo-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}