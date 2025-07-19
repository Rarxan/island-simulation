package com.javarush.rybalchenko.islandsimulation.model;

public class Fox extends Predator{
    public Fox() {
        super(8.0, 30, 2, 2.0);
    }

    @Override
    public void move() {
        System.out.println("\uD83E\uDD8A The fox is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("\uD83E\uDD8A The fox is reproducing");
    }

    @Override
    public void eat() {
        System.out.println("\uD83E\uDD8A The fox is eating");
    }
}
