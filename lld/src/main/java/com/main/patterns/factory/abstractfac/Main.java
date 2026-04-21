package com.main.patterns.factory.abstractfac;

public class Main {
    public static void main(String[] args) {
        ExteriorFactory factory = (ExteriorFactory) AbstractFactory.getFactory("exterior");
        Carexterior c = factory.createCarexter("luxury");
        c.addComponent();
    }
}
