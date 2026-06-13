package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalVehicleType;
import com.main.desgins.carrental.self.models.Store;
import com.main.desgins.carrental.self.models.User;

import java.util.List;

public interface StoreSelectionStrategy {
    Store selectStore(RentalVehicleType vehicleType, User user, List<Store> stores);
}
