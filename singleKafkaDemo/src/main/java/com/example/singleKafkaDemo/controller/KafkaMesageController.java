package com.example.singleKafkaDemo.controller;

import com.example.singleKafkaDemo.services.ProducerService;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaMesageController {

    @Autowired
    ProducerService producerService;
    @GetMapping("/produceMsg")
    public String  produceMessage(@RequestParam("message") String message){
        producerService.sendMessage(message);
        return "success";
    }


}
