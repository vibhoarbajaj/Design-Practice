package com.main.desgins.carrental.self.services;

import com.main.desgins.carrental.self.models.RentalVehicleType;
import com.main.desgins.carrental.self.models.Store;
import com.main.desgins.carrental.self.models.User;

import java.util.List;

public class NearestStoreStrategy implements StoreSelectionStrategy {

    @Override
    public Store selectStore(RentalVehicleType vehicleType, User user, List<Store> stores) {
        int distance = Integer.MAX_VALUE;
        Store nearestStore = null;
        for (Store store : stores) {
            int newd = (store.getLocation().getX() * store.getLocation().getX() + store.getLocation().getY() * store.getLocation().getY())
                    - (user.getLocation().getX() * user.getLocation().getX() + user.getLocation().getY() * user.getLocation().getY());
            if (newd < distance) {
                distance = newd;
                nearestStore = store;
            }
        }
        return nearestStore;
    }
}
