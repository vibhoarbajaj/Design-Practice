package com.main.desgins.parkinglot;

import com.main.desgins.parkinglot.entities.Ticket;
import com.main.desgins.parkinglot.entities.gates.EntranceGate;
import com.main.desgins.parkinglot.entities.gates.ExitGate;
import com.main.desgins.parkinglot.entities.parking.ParkingBuilding;
import com.main.desgins.parkinglot.entities.parking.ParkingLevel;
import com.main.desgins.parkinglot.entities.parking.ParkingLot;
import com.main.desgins.parkinglot.entities.parking.ParkingSpot;
import com.main.desgins.parkinglot.entities.payment.Payment;
import com.main.desgins.parkinglot.entities.payment.UpiPayment;
import com.main.desgins.parkinglot.entities.vehicle.Vehicle;
import com.main.desgins.parkinglot.entities.vehicle.VehicleType;
import com.main.desgins.parkinglot.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingSpotId("1");
        ParkingSpot parkingSpot2 = new ParkingSpot();
        parkingSpot2.setParkingSpotId("2");
        ParkingSpot parkingSpot3 = new ParkingSpot();
        parkingSpot3.setParkingSpotId("3");
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        parkingSpotList.add(parkingSpot);
        parkingSpotList.add(parkingSpot2);
        parkingSpotList.add(parkingSpot3);

        ParkingLot parkingLot = getParkingLot(parkingSpotList);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("6969");
        vehicle.setEntryGateNumber(2);
        vehicle.setExitGateNumber(1);
        vehicle.setVehicleType(VehicleType.FOUR_WHEELER);

        Ticket ticket = parkingLot.vehicleArrives(vehicle);
        Payment payment = new UpiPayment();
        parkingLot.vehicleExit(ticket, payment);

    }

    private static ParkingLot getParkingLot(List<ParkingSpot> parkingSpotList) {
        ParkingLevel parkingLevel = new ParkingLevel(1, Map.of(VehicleType.TWO_WHEELER, new TwoWheelerSpotManager(parkingSpotList, new RandomParkingStrategy())));
        ParkingLevel parkingLeve2 = new ParkingLevel(2, Map.of(VehicleType.FOUR_WHEELER, new FourWheelerSpotManager(parkingSpotList, new RandomParkingStrategy()), VehicleType.TWO_WHEELER, new TwoWheelerSpotManager(parkingSpotList, new RandomParkingStrategy())));
        List<ParkingLevel> parkingLevels = new ArrayList<>();
        parkingLevels.add(parkingLevel);
        parkingLevels.add(parkingLeve2);
        ParkingBuilding parkingBuilding = new ParkingBuilding(parkingLevels);


        EntranceGate entranceGate = new EntranceGate(1);
        EntranceGate entranceGate2 = new EntranceGate(2);
        List<EntranceGate> entranceGates = new ArrayList<>();
        entranceGates.add(entranceGate);
        entranceGates.add(entranceGate2);

        PricingStrategy pricingStrategy = new FixesPricingStrategy();
        CostComputation costComputation = new CostComputation(pricingStrategy);

        ExitGate exitGate = new ExitGate(1,costComputation);
        ExitGate exitGate2 = new ExitGate(2,costComputation);
        List<ExitGate> exitGates = new ArrayList<>();
        exitGates.add(exitGate);
        exitGates.add(exitGate2);

        return new ParkingLot(parkingBuilding, entranceGates, exitGates);
    }
}
