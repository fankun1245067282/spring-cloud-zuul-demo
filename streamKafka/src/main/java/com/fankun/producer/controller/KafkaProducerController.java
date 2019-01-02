package com.fankun.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生产者controller
 */
@RestController
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String topic;
    @Autowired
    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate,
                                   @Value("${kafka.topic}") String topic ) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @PostMapping("/message/send")
    public Boolean sendMessage(@RequestParam String message){
        System.out.println("send a message to kafka:"+message);
        kafkaTemplate.send(topic, message);//send执行完，不一定发送到kafka
        return true;
    }
}
