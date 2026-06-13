package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Reservation {

    private final List<Store> stores;
    private final StoreSelectionStrategy storeSelectionStrategy;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Ticket reserveCar(RentalVehicleType vehicleType, User user) {
        Store store = storeSelectionStrategy.selectStore(vehicleType, user, stores);
        RentalVehicle rentalVehicle = store.selectRentalVehicle(vehicleType);
        rentalVehicle.reserveVehicle();
        user.setRentalVehicle(rentalVehicle);
        this.startTime = LocalDateTime.now();
        user.setReservations(this);
        return new Ticket(UUID.randomUUID(), rentalVehicle, user);
    }

    public void returnCar(Ticket ticket) {

    }
}
