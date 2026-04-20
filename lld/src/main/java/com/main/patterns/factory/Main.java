package com.main.patterns.factory;

public class Main {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape(ShapeName.CIRCLE);
        circle.getName();
    }
}
