package com.main.desgins.carrental.self.models;

import com.main.desgins.carrental.self.services.Reservation;
import lombok.Data;


@Data
public class User {
    private int id;
    private String username;
    private RentalVehicle rentalVehicle;
    private Location location;
    private Reservation reservations;
}
