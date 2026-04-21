package com.main.desgins.parkinglot.entities;

import lombok.Data;

@Data
public class ParkingSpot {
     String parkingSpotId;
     boolean parked;

     public void releaseSpot(){
         parked = false;
     }
     public void occupySpot(){
         parked = true;
     }
}
