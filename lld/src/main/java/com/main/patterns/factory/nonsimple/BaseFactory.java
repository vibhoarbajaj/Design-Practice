package com.main.patterns.factory.nonsimple;

import com.main.patterns.factory.ShapeName;

public class BaseFactory {
    public static Shape createShape(ShapeName shapeName) {
        if(shapeName.equals(ShapeName.CIRCLE)){
            CircleFactory circleFactory = new CircleFactory();
            return circleFactory.createShape();
        }
        else if(shapeName.equals(ShapeName.SQUARE)){
            SquareFactory squareFactory = new SquareFactory();
            return squareFactory.createShape();
        }
        return null;
    }
}
