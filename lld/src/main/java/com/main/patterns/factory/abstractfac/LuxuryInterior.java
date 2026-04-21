package com.main.patterns.factory.abstractfac;

public class LuxuryInterior implements CarInterior {
    @Override
    public void addComponent() {
        System.out.println("LuxuryInterior addComponent");
    }
}
