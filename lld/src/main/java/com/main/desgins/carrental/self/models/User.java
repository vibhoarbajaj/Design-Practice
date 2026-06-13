package com.main.desgins.carrental.self.models;

import lombok.Data;

import javax.xml.stream.Location;
import java.time.LocalDateTime;

@Data
public class User {
    private String username;
    private RentalVehicle rentalVehicle;
    private Bill bill;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Location location;
}
