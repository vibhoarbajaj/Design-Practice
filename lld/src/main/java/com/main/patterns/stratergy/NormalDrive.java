package com.main.patterns.stratergy;

public class NormalDrive implements Drive {
    public void drive() {
        // this is done for less code duplication
        System.out.println("this is a normal drive method");
    }
}
