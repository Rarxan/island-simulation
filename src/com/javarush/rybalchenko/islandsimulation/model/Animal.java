package com.javarush.rybalchenko.islandsimulation.model;

public abstract class Animal {

    protected double weight;
    protected int maxCount;
    protected int speed;
    protected double foodRequired;

    public Animal(double weight, int maxCount, int speed, double foodRequired) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.foodRequired = foodRequired;
    }

    public abstract void move();

    public abstract void reproduce();

    public abstract void eat();

}
