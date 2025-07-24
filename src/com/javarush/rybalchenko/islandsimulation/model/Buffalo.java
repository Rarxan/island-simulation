package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.List;

public class Buffalo extends Herbivore {
    public Buffalo() {
        super(700.0, 10, 3, 100.0);
    }

    @Override
    public void move() {
        System.out.println(Emojis.BUFFALO + " Buffalo is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.BUFFALO + " Buffalo is reproducing");
    }

    @Override
    public void eat() {
        List<Plant> plants = currentLocation.getPlants();
        synchronized (plants) {
            int needToEat = (int) Math.min(foodRequired - foodEaten, plants.size());

            for (int i = 0; i < needToEat; i++) {
                plants.remove(0);
                addFood(1.0);
            }
            System.out.println(Emojis.BUFFALO + " Buffalo is eating " + needToEat + " plants");
        }
    }
}
