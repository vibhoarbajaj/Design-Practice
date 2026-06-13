package com.main.desgins.carrental.self.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.stream.Location;
import java.util.List;

@Data
@AllArgsConstructor
public class Store {
    private String storeName;
    private String storeId;
    private List<RentalVehicle> rentalVehicleList;
    private Location location;

    public boolean hasRentalVehicle(RentalVehicleType vehicleType) {
        return rentalVehicleList != null && !rentalVehicleList.isEmpty() &&
                rentalVehicleList.stream()
                        .anyMatch((vehicle) -> vehicle.getRentalVehicleType().equals(vehicleType) && vehicle.isFree());

    }

    public RentalVehicle selectRentalVehicle(RentalVehicleType vehicleType) {
        return null;
    }

}
