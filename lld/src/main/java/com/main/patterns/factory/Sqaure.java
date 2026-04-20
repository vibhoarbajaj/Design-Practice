package com.main.patterns.factory;

public class Sqaure implements Shape{

    @Override
    public String getName() {
        System.out.println("this is a square");
        return "This is a Sqaure";
    }
}
