package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.Store;
import com.main.desgins.carrental.self.models.User;
import com.main.desgins.parkinglot.entities.vehicle.VehicleType;

import java.util.List;

public interface StoreSelectionStrategy {
    Store selectStore(VehicleType vehicleType, User user, List<Store>stores);
}
