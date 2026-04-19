package com.main.stratergypattern;

public class main {
    public static void main(String[] args) {
        Drive sports = new SportsDrive();
        Drive normal = new NormalDrive();
        Vehicle car = new Car(sports);
        Vehicle bike  = new Bike(normal);
        car.run();
        bike.run();
    }
}
