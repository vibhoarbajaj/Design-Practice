package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalVehicleType;
import com.main.desgins.carrental.self.models.Store;
import com.main.desgins.carrental.self.models.Ticket;
import com.main.desgins.carrental.self.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class Reservation {

    private final List<Store> stores;
    private final StoreSelectionStrategy storeSelectionStrategy;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Ticket reserveCar(RentalVehicleType vehicleType, User user) {
        Store store = storeSelectionStrategy.selectStore(vehicleType, user, stores);
        return null;
    }
    public void returnCar(Ticket ticket) {

    }
}
