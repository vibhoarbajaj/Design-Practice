package com.main.desgins.carrental.self.models;

import com.main.desgins.carrental.self.services.Reservation;
import lombok.Data;



@Data
public class User {
    private String username;
    private RentalVehicle rentalVehicle;
    private Bill bill;
    private Location location;
    private Reservation reservations;
}
