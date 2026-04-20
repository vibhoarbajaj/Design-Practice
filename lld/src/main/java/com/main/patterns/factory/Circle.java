package com.main.patterns.factory;

public class Circle implements Shape {
    @Override
    public String getName() {
        System.out.println("this is a circle");
        return "this is a circle";
    }
}
