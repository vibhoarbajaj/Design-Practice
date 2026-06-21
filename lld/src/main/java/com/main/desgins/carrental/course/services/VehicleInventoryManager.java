package com.main.desgins.carrental.course.services;

import com.main.desgins.carrental.course.models.RentalVehicle;
import com.main.desgins.parkinglot.entities.vehicle.VehicleType;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@RequiredArgsConstructor
public class VehicleInventoryManager {
    private final ReservationRepository reservationRepository;
    private ConcurrentHashMap<Integer, RentalVehicle> vehicles;
    private ConcurrentHashMap<Integer, List<Integer>> vehicleBookingIds; // vehicle ,{reservationID1,reservationID2}

    public void addRentalVehicle(RentalVehicle rentalVehicle) {
        vehicles.putIfAbsent(rentalVehicle.getVehicleId(), rentalVehicle);
    }

    public void removeRentalVehicle(RentalVehicle rentalVehicle) {
        vehicles.remove(rentalVehicle.getVehicleId());
    }

    public RentalVehicle selectRentalVehicle(VehicleType vehicleType) {
        for (RentalVehicle rentalVehicle : vehicles.values()) {
            if (rentalVehicle.getVehicleType().equals(vehicleType)) {
                return rentalVehicle;
            }
        }
        return null;
    }


}
