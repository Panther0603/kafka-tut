package com.example.config;

import com.example.contsant.AppConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class kafkaConfig {

    @Bean
    public NewTopic getTopic(){
        // first topic. second-no partition,3-no replicas
        return new NewTopic(AppConstant.DRIVER_LOCATION,1,(short)(1));
    }

    @Bean
    public NewTopic getTopic5Partition(){
        // first topic. second-no partition,3-no replicas
        return new NewTopic(AppConstant.DRIVER_LOCATION1,5,(short)(1));
    }
}
