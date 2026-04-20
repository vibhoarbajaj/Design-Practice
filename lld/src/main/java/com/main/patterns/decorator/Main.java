package com.main.patterns.decorator;

public class Main {
    public static void main(String[] args) {
     BasePizza mushroom = new MushroomBasePizza();
     BasePizza mushroomWithCheeseTopping  = new CheeseTopping(mushroom);
        System.out.println(mushroomWithCheeseTopping.getDescription());
        System.out.println(mushroomWithCheeseTopping.getPrice());
        BasePizza mushroomWithCheeseToppingAndPaneerTopping = new PaneerTopping(mushroomWithCheeseTopping);
        System.out.println(mushroomWithCheeseToppingAndPaneerTopping.getDescription());
        System.out.println(mushroomWithCheeseToppingAndPaneerTopping.getPrice());
    }
}
