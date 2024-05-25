package com.example.service;

import com.example.contsant.AppConstant;
import com.example.dto.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public DriverDto sendCurrentLocation(DriverDto driverDto){

        driverDto.setIsUpdated(true);
        String information=driverDto.toString();
        kafkaTemplate.send(AppConstant.DRIVER_LOCATION,driverDto);
        return  driverDto;
    }


    public DriverDto sendCurrentLocationToParticularPartition(DriverDto driverDto){

        driverDto.setIsUpdated(true);

        // here we have pass to the which partition of the topic i have to send the messages
        // same thing we can do with consumer

        kafkaTemplate.send(AppConstant.DRIVER_LOCATION1,2,null,driverDto);


        return  driverDto;
    }
}
