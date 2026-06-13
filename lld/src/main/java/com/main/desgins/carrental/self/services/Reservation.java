package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.Store;
import com.main.desgins.carrental.self.models.User;
import com.main.desgins.parkinglot.entities.vehicle.VehicleType;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Reservation {

    private final List<Store> stores;
    private final StoreSelectionStrategy storeSelectionStrategy;

    public void reserveCar(VehicleType vehicleType, User user) {
        Store store =  storeSelectionStrategy.selectStore(vehicleType, user, stores);

    }
}
