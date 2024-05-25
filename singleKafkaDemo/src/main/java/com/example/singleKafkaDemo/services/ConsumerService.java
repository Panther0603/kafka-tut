package com.example.singleKafkaDemo.services;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

//    @KafkaListener(topics = "MyKafka",groupId = "codeDecode")
//    public void listenToTopic (String receivedMessage){
//        System.out.println( "message received  "+receivedMessage);
//
//    }

    @KafkaListener(groupId = "user-group", containerFactory = "kafkaListenerContainerFactory", autoStartup = "true")
    public void getData(String driverName, String location){
        String topic = "MY_KAFKA_CAB_LOCATION" + driverName;
        System.out.println("Subscribed to topic: " + topic);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Location: " + location);
    }
}
