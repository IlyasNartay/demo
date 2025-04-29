package com.example.demo.controller;

import com.example.demo.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        messageProducer.sendMessage("demo-topic", message);
        return "Message sent: " + message;
    }
}