package com.main.patterns.decorator;

public abstract class Toppings implements BasePizza{
    // todo is a basepizza and has a basepizza this is the crux of this pattern
    BasePizza basePizza;
    public Toppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

}
