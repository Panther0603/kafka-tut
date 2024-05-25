package com.example.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableKafka
public class KafkaConsumerConfig {


    private static final String GROUP_ID = "driver-user";
//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
//    @Bean
//    public ConsumerFactory<String, DriverDto> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//
//        logger.debug(GROUP_ID);
//        // Configure key deserializer with ErrorHandlingDeserializer
//        ErrorHandlingDeserializer<String> keyDeserializer = new ErrorHandlingDeserializer<>(new StringDeserializer());
//
//        // Configure value deserializer with ErrorHandlingDeserializer
//        ErrorHandlingDeserializer<DriverDto> valueDeserializer = new ErrorHandlingDeserializer<>(new JsonDeserializer<>(DriverDto.class));
//        return new DefaultKafkaConsumerFactory<>(props, keyDeserializer, valueDeserializer);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, DriverDto> kafkaListenerContainerFactory() {
//
//        ConcurrentKafkaListenerContainerFactory<String, DriverDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }


    @Bean
    public Map<String,Object> getConsumerConfig(){
        Map<String ,Object> props= new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,GROUP_ID);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        props.put(JsonDeserializer.TRUSTED_PACKAGES,"com.example.dto");
        return props;
    }

    @Bean
    public ConsumerFactory<String,Object> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(getConsumerConfig());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
