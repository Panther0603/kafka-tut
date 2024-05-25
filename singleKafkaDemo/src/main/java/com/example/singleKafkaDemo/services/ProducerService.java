package com.example.singleKafkaDemo.services;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {


    // first thing we need a kafka template  which will hold the topic and content
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public  void sendMessage(String message){

        // we have mapped the kafka message with a topic
        kafkaTemplate.send("MyKafka",message);
    }

}
