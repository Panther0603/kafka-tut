package com.example.cabuser.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @KafkaListener(topics = "MY_KAFKA_CAB_LOCATION1",groupId = "user-group1")
    public void getData(String location){
        System.out.println("location  "+1+"  "+location);
    }

    @KafkaListener(topics = "MY_KAFKA_CAB_LOCATION1",groupId = "user-group1")
    public void getData1(String location){
        System.out.println("location  "+2+"  "+location);
    }

    @KafkaListener(topics = "MY_KAFKA_CAB_LOCATION1",groupId = "user-group1")
    public void getData2(String location){
        System.out.println("location  "+3+"  "+location);
    }
    @KafkaListener(topics = "MY_KAFKA_CAB_LOCATION1",groupId = "user-group1")
    public void getData3(String location){
        System.out.println("location  "+4+"  "+location);
    }

}
