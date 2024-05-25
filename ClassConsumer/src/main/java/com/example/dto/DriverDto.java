package com.example.dto;

import lombok.Data;

@Data
public class DriverDto {

    private String driverName;
    private String latitude;
    private String longitude;
    private Boolean isUpdated;
}
