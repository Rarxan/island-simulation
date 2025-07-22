package com.javarush.rybalchenko.islandsimulation.model;

public abstract class Predator extends Animal {
    public Predator(double weight, int maxCount, int speed, double foodRequired) {
        super(weight, maxCount, speed, foodRequired);
    }

}
