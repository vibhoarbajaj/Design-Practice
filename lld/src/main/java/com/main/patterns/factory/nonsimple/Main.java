package com.main.patterns.factory.nonsimple;

import com.main.patterns.factory.ShapeName;

public class Main {
    public static void main(String[] args) {
        Shape sh =BaseFactory.createShape(ShapeName.CIRCLE);
        sh.draw();
    }
}
