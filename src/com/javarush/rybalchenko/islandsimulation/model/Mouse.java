package com.javarush.rybalchenko.islandsimulation.model;

public class Mouse extends Herbivore{
    public Mouse() {
        super(0.05, 500, 1, 0.01);
    }

    @Override
    public void move() {
        System.out.println("\uD83D\uDC01 The mouse is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("\uD83D\uDC01 The mouse is reproducing");
    }

    @Override
    public void eat() {
        System.out.println("\uD83D\uDC01 The mouse is eating");
    }
}
