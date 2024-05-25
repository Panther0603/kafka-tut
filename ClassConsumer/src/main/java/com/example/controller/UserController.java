package com.example.controller;

import com.example.dto.DriverDto;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;
    @GetMapping("/driverLocationUpdate")
    public ResponseEntity<DriverDto> getDriverLocationUpdate(){
        DriverDto latestDriverDto = userService.getLatestDriverDto();
        if (latestDriverDto != null) {
            return ResponseEntity.ok(latestDriverDto);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
