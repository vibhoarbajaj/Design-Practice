package com.main.desgins.carrental.self.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class Ticket {
    private UUID id;
    private RentalVehicle vehicle;
    private User user;
}
