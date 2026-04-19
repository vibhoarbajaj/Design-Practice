package com.main.patterns.stratergypattern;

public class NormalDrive implements Drive {
    public void drive() {
        // this is done for less code duplication
        System.out.println("this is a normal drive method");
    }
}
