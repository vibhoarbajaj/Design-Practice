package com.main.desgins.parkinglot.entities.payment;

public class CashPayment implements Payment {


    @Override
    public boolean pay(double amt) {
        System.out.println("cash payment " + amt);
        return true;
    }
}
