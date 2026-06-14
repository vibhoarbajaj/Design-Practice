package com.main.desgins.carrental.self.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RentalVehicle {
    private int id;
    private int vehicleNumber;
    private RentalVehicleType rentalVehicleType;
    private int cost;
    private boolean isFree = true;

    public void reserveVehicle() {
        isFree = false;
    }
    public void unreserveVehicle() {
        isFree = true;
    }
}
