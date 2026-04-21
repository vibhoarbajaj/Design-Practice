package com.main.patterns.factory.abstractfac;

public class AbstractFactory {
    public static Object  getFactory(String type){
        if(type.equalsIgnoreCase("exterior")){
            return new ExteriorFactory();
        }
        if(type.equalsIgnoreCase("interior")){
            return new InteriorFactory();
        }
        return null;
    }
}
