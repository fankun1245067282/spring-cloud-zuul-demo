package com.fankun.comsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka消费者监听器
 */
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics="${kafka.topic}")//
    public void onMessage(String message) {
        System.out.println("Kafka 消费者监听器，接受消息：" + message);
    }
}
