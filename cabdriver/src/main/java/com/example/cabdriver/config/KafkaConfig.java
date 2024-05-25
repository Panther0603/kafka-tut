package com.example.cabdriver.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

//
//    @Bean
//    public NewTopic createTopic(){
//        return TopicBuilder.name("MY_KAFKA_CAB_LOCATION").build();
//    }


    @Bean
    public NewTopic createTopicWithPartition(){
        return  new NewTopic(AppConstant.CAB_LOCATION,3, (short) 1);
    }

}
