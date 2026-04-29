package com.main.desgins.parkinglot.entities.payment;

public class UpiPayment implements Payment {

    @Override
    public boolean pay(double amt) {
        System.out.println("upi payment " + amt);
        return true;
    }
}
