package com.main.patterns.decorator;

public class CheeseTopping extends Toppings{

    public CheeseTopping(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return this.basePizza.getDescription() + " cheese";
    }

    @Override
    public int getPrice() {
        return this.basePizza.getPrice() + 122;
    }
}
