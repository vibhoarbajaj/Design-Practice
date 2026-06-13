package com.main.desgins.carrental.self.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Store {
    private String storeName;
    private String storeId;
    private List<RentalVehicle> rentalVehicleList;
}
