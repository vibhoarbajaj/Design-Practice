package com.main.patterns.factory;

public class ShapeFactory {
    public static Shape getShape(ShapeName shapeName) {
        if (shapeName.equals(ShapeName.CIRCLE)) {
            return new Circle();
        } else if (shapeName.equals(ShapeName.SQUARE)) {
            return new Sqaure();
        }
        return null;
    }
}
