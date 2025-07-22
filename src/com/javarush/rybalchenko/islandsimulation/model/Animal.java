package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.map.Location;

public abstract class Animal {

    protected double weight;
    protected int maxCount;
    protected int speed;
    protected double foodRequired;
    protected double foodEaten = 0;
    protected boolean alive = true;

    protected Location currentLocation;

    public Animal(double weight, int maxCount, int speed, double foodRequired) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.foodRequired = foodRequired;
    }


    public void liveCykle() {

        eat();
        move();
        reproduce();

        if (foodEaten < foodRequired) {
            System.out.println(getClass().getSimpleName() + " is starving!");
            alive = false;
        } else {
            foodEaten = 0;
        }
    }

    public void addFood(double amount) {
        foodEaten += amount;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public boolean isAlive() {
        return alive;
    }

    public abstract void move();

    public abstract void reproduce();

    public abstract void eat();

}
