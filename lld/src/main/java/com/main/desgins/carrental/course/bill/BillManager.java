package com.main.desgins.carrental.course.bill;

import lombok.AllArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class BillManager {
    private final ConcurrentHashMap<Integer, Bill>   billMap = new ConcurrentHashMap<Integer, Bill>();
    private final BillStratergy billStratergy;

    public Bill getBill(int reservationId) {
        return billStratergy.generateBill(reservationId);
    }
}
