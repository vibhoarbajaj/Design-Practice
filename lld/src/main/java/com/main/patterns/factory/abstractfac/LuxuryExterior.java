package com.main.patterns.factory.abstractfac;

public class LuxuryExterior implements Carexterior {
    @Override
    public void addComponent() {
        System.out.println("LuxuryExterior addComponent");
    }
}
