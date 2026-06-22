package com.main.desgins.carrental.course.services;

import com.main.desgins.carrental.course.models.RentalVehicle;
import com.main.desgins.carrental.course.models.Reservation;
import com.main.desgins.parkinglot.entities.vehicle.VehicleType;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;


@RequiredArgsConstructor
public class VehicleInventoryManager {
    private final ReservationRepository reservationRepository;
    private ConcurrentHashMap<Integer, ReentrantLock> vehicleLocks;
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

    public Optional<RentalVehicle> selectRentalVehicle(int vehicleId) {
        return Optional.ofNullable(vehicles.get(vehicleId));
    }

    private ReentrantLock getVehicleLock(int vehicleId) {
        vehicleLocks.putIfAbsent(vehicleId, new ReentrantLock());
        return vehicleLocks.get(vehicleId);
    }

    public void release(int vehicleId, int reservationId) {
        ReentrantLock lock = getVehicleLock(vehicleId);
        lock.lock();
        try {
            List<Integer> bookingIds = vehicleBookingIds.get(vehicleId);
            if (bookingIds != null) {
                bookingIds.remove(reservationId);
            }

            List<Integer> stillBooked = vehicleBookingIds.get(vehicleId);
            if (stillBooked == null || stillBooked.isEmpty()) {
                vehicles.get(vehicleId).setStatus(true);
            }

        } finally {
            lock.unlock();
        }
    }

    public boolean isAvailable(int vehicleId, LocalDate from, LocalDate to) {
        RentalVehicle vehicle = vehicles.get(vehicleId);
        if (vehicle == null) {// isavailable
            return false;
        }
        if (!vehicle.isStatus()) { // isfree
            return false;
        }

        List<Integer> reservationIds = vehicleBookingIds.get(vehicleId);
        if (reservationIds == null || reservationIds.isEmpty()) {
            return true;
        }
        for (int reservationId : reservationIds) { // overlap
            Reservation reservation = reservationRepository.find(reservationId);

            LocalDate bookedFrom = reservation.getBookingDateFrom()

                    .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            LocalDate bookedTo = reservation.getBookingDateTo()

                    .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            boolean overlap = !(to.isBefore(bookedFrom) || from.isAfter(bookedTo));
            if (overlap) {
                return false;
            }
        }
        return true;
    }

    public boolean reserve(int vehicleId, int reservationId, LocalDate from, LocalDate to) {
        ReentrantLock lock = getVehicleLock(vehicleId);
        lock.lock();
        try {
            if (!isAvailable(vehicleId, from, to)) {
                return false;
            }
            vehicleBookingIds.putIfAbsent(vehicleId, new ArrayList<>());
            vehicleBookingIds.get(vehicleId).add(reservationId);
            vehicles.get(vehicleId).setStatus(false);
            return true;
        } finally {
            lock.unlock();
        }
    }

    public List<RentalVehicle> getAvailableVehicles(VehicleType vehicleType, LocalDate from, LocalDate to) {
        return vehicles.values().stream()
                .filter(v -> v.getVehicleType().equals(vehicleType))
                .filter(v -> isAvailable(v.getVehicleId(), from, to))
                .collect(Collectors.toList());
    }

}
