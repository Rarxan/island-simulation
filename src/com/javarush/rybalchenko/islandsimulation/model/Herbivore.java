package com.javarush.rybalchenko.islandsimulation.model;

public abstract class Herbivore extends Animal {

    public Herbivore(double weight, int maxCount, int speed, double foodRequired) {
        super(weight, maxCount, speed, foodRequired);
    }
}
