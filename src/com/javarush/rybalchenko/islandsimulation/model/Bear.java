package com.javarush.rybalchenko.islandsimulation.model;

public class Bear extends Predator {


    public Bear() {
        super(500.0, 5, 2, 80.0);
    }

    @Override
    public void move() {
        System.out.println("\uD83D\uDC3B A bear is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("\uD83D\uDC3B The bear is reproducing");
    }

    @Override
    public void eat() {
        System.out.println("\uD83D\uDC3B The bear is eating");
    }
}
