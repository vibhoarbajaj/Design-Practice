package com.main.desgins.carrental.self.models;

import lombok.Data;

@Data
public class RentalVehicle {
    private int id;
    private int vehicleNumber;
    private RentalVehicleType rentalVehicleType;
    private int cost;
    private boolean isFree = true;
}
