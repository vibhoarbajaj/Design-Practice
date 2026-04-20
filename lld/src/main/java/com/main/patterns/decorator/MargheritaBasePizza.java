package com.main.patterns.decorator;

public class MargheritaBasePizza implements BasePizza {

    @Override
    public String getDescription() {
        return "This is a Margherita Pizza";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
