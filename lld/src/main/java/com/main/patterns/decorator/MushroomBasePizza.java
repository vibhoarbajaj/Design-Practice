package com.main.patterns.decorator;

public class MushroomBasePizza implements BasePizza {
    @Override
    public String getDescription() {
        return "This is a Mushroom Pizza";
    }

    @Override
    public int getPrice() {
        return 1223;
    }
}
