package com.example.kafkaproducer;

import com.example.kafkaproducer.services.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

/**
 * @author ankurmundra
 * May 22, 2023
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    private final KafkaProducerService kafkaProducerService;

    public MessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping
    public ResponseEntity<String> getMessage(@RequestParam("message") String message) {
        // select random choice from array
        int random = new Random().nextInt(2);
        String key = new String[]{"key1", "key2"}[random];
        kafkaProducerService.sendMessage(key, message);
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
       kafkaProducerService.sendMessage(message);
         return ResponseEntity.ok("Message sent successfully");
    }
}
