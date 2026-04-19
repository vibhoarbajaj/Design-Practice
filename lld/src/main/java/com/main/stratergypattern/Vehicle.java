package com.main.stratergypattern;

public class Vehicle {

    private Drive drive;
    // we can choose which kind of drive the vehicle wants and use that -- important
    public Vehicle(Drive drive) {
        this.drive = drive;
    }
    public void run(){
        System.out.println("Running the vehicle");
        drive.drive();
    }
}
