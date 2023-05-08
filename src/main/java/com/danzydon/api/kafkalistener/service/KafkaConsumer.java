package com.danzydon.api.kafkalistener.service;

import com.danzydon.api.kafkalistener.model.UserRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(UserRecord user) {
        System.out.println("Consumed JSON Message: " + user);
    }
    /*@KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }*/

    @KafkaListener(topics = "kafka-spring-producer", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void listenWithHeaders(
            @Payload UserRecord message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: \n" + message + "\nfrom partition: " + partition);
    }
}