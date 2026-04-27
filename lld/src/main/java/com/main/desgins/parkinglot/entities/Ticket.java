package com.main.desgins.parkinglot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Ticket {
    private final Vehicle vehicle;
    private final ParkingLevel parkingLevel;
    private  final ParkingSpot parkingSpot;
    private final LocalDateTime parkingTime;
}
