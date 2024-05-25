package com.example.cabdriver.controller;

import com.example.cabdriver.service.DriverProducer;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/driver")
public class CabDriver {

    @Autowired
    private DriverProducer producer;


    @PostMapping()
    public ResponseEntity<HashMap<String,String>> updateLocation(@RequestParam("username")String username){
       return ResponseEntity.ok(producer.allUpdatedLocation());
    }

}
