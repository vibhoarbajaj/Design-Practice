package com.main.desgins.carrental.self.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String username;
    private RentalVehicle RentalVehicle;
    private Bill bill;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
