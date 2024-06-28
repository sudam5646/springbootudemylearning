package com.kafka.springboot_kafka_tutorial.controller;

import com.kafka.springboot_kafka_tutorial.kafka.JsonKafkaProduce;
import com.kafka.springboot_kafka_tutorial.kafka.KafkaProducer;
import com.kafka.springboot_kafka_tutorial.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private JsonKafkaProduce kafkaProducer;

    public JsonMessageController(JsonKafkaProduce kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
