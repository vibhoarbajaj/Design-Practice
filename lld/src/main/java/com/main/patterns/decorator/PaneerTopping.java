package com.main.patterns.decorator;

public class PaneerTopping extends Toppings{

    public PaneerTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return this.basePizza.getDescription() + " paneer";
    }

    @Override
    public int getPrice() {
        return this.basePizza.getPrice() + 1233;
    }
}
