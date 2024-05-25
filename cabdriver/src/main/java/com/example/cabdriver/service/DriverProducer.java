package com.example.cabdriver.service;

import com.example.cabdriver.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class DriverProducer {
    
    
//    @Autowired
//    KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;
    private void updateLocation(String lat, String lan){
        String message="latitude =: "+lat+"\n longitude =: "+lan;
        try{
            kafkaTemplate.send(AppConstant.CAB_LOCATION,message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HashMap<String,String> allUpdatedLocation(){
        HashMap<String,String> allUpdatedLocationCoordinates=new HashMap<>();
        Random random=new Random(10000);
        for(int i=0;i<10000;i++){
            String lat=random.nextDouble()+"";
            String lan=random.nextDouble()+"";
            updateLocation(lat,lan);

            try {

                allUpdatedLocationCoordinates.put(lan,lan);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return allUpdatedLocationCoordinates;
    }

}
