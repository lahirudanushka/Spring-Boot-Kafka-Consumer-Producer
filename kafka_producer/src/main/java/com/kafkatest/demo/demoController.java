package com.kafkatest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
public class demoController {
    @Autowired
    KafkaTemplate<String,Book> kafkaTemplate;

    private static final String TOPIC = "TestTopic";
    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book){
        kafkaTemplate.send(TOPIC,book);
        return  "published";
    }
}
