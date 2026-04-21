package com.main.patterns.factory.abstractfac;

public class EconomyInterior implements CarInterior {
    @Override
    public void addComponent() {
        System.out.println("Economy Interior");
    }
}
