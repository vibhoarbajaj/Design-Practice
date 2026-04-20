package com.main.patterns.factory.nonsimple;

public class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }

}
