package com.example.controller;

import com.example.dto.DriverDto;
import com.example.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/locationUpdate")
    public ResponseEntity<DriverDto> updateLocation(@RequestBody DriverDto driverDto){
        driverDto=driverService.sendCurrentLocation(driverDto);
        return ResponseEntity.ok(driverDto);
    }

    @PostMapping("/locationUpdate1")
    public ResponseEntity<DriverDto> updateLocationSendingFromParticularPartition(@RequestBody DriverDto driverDto){
        driverDto=driverService.sendCurrentLocationToParticularPartition(driverDto);
        return ResponseEntity.ok(driverDto);
    }
}
