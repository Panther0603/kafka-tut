package com.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder
public class DriverDto {

    private String driverName;
    private String latitude;
    private String longitude;
    private Boolean isUpdated;

}
