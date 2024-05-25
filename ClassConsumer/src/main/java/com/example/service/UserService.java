package com.example.service;

import com.example.constant.AppConstant;
import com.example.dto.DriverDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private volatile DriverDto latestDriverDto;

    @KafkaListener(topics = AppConstant.DRIVER_LOCATION,groupId = "driver-user")
    public void getUpdatedLocation(DriverDto driverDto){
        System.out.println(driverDto.toString());
        //this.latestDriverDto=driverDto;
      //  return driverDto;
    }

    @KafkaListener(topics = AppConstant.DRIVER_LOCATION1,groupId = "driver-user12",
            topicPartitions = @TopicPartition(topic = AppConstant.DRIVER_LOCATION1, partitions = {"2"}))
    public void getUpdatedLocationFromParticularPartition(DriverDto driverDto){
        System.out.println(driverDto.toString());
        this.latestDriverDto=driverDto;
        //  return driverDto;
    }

    public DriverDto getLatestDriverDto() {
        return latestDriverDto;
    }
}
