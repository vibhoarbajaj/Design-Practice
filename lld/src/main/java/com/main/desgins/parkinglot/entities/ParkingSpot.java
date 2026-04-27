package com.main.desgins.parkinglot.entities;

import lombok.Data;

@Data
public class ParkingSpot {
     String parkingSpotId;
     boolean isFree= true;

     public void releaseSpot(){
         isFree = true;
     }
     public void occupySpot(){
         isFree = false;
     }
     public boolean isSpotFree(){
         return isFree;
     }
}
