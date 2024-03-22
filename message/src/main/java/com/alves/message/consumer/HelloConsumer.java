package com.alves.message.consumer;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class HelloConsumer {

    @KafkaListener(topics = "hello-topic", groupId = "group-1")
    public void receiveMesage(String message){
        System.out.println("Consumer Message: " + message);
    }
}
