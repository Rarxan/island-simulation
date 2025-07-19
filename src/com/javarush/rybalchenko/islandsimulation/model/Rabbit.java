package com.javarush.rybalchenko.islandsimulation.model;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(2.0, 150, 2, 0.45);
    }

    @Override
    public void move() {
        System.out.println("\uD83D\uDC07 Rabbit is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("\uD83D\uDC07 Rabbit is reproducing");
    }

    @Override
    public void eat() {
        System.out.println("\uD83D\uDC07 Rabbit is eating");
    }
}
