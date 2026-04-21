package com.main.patterns.factory.abstractfac;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExteriorFactory {

    public static Carexterior createCarexter(String carType) {
        if(carType.equals("economy")){
            return new EconomyExterior();
        }
        else if(carType.equals("luxury")){
            return new LuxuryExterior();
        }
        return null;
    }
}
