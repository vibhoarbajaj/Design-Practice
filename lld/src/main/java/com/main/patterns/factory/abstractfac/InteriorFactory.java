package com.main.patterns.factory.abstractfac;


public class InteriorFactory {
    public static CarInterior createFactory(String type){
        if(type.equalsIgnoreCase("economy")){
            return new EconomyInterior();
        }
        else if(type.equalsIgnoreCase("luxury")){
                return  new LuxuryInterior();
        }
        return null;
    }
}
