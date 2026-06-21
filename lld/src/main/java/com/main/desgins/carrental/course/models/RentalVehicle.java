package com.main.desgins.carrental.course.models;

import com.main.desgins.parkinglot.entities.vehicle.VehicleType;
import lombok.Data;

@Data
public class RentalVehicle {
    private int vehicleId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    double cost;
    boolean status;

}
