package com.javarush.rybalchenko.islandsimulation.model;

public class Horse extends Herbivore {
    public Horse() {
        super(400.0, 20, 4, 60.0);
    }

    @Override
    public void move() {
        System.out.println("\uD83D\uDC0E Horse is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("\uD83D\uDC0E Horse is reproducing");
    }

    @Override
    public void eat() {
        System.out.println("\uD83D\uDC0E Horse is eating");
    }
}
