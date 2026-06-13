package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.Store;
import com.main.desgins.carrental.self.models.User;
import com.main.desgins.parkinglot.entities.vehicle.VehicleType;

import java.util.List;

public class NearestStoreStrategy implements StoreSelectionStrategy{

    @Override
    public Store selectStore(VehicleType vehicleType, User user, List<Store> stores) {
        return null;
    }
}
