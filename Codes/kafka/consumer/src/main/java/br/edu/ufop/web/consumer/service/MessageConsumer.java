package br.edu.ufop.web.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "sales", groupId = "tickets")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

}