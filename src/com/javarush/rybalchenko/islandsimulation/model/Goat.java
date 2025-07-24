package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.List;

public class Goat extends Herbivore {
    public Goat() {
        super(60.0, 140, 3, 10);
    }

    @Override
    public void move() {
        System.out.println(Emojis.GOAT + " Goat is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.GOAT + " Goat is reproducing");
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
            System.out.println(Emojis.GOAT + " Goat is eating " + needToEat + " plants");
        }
    }
}
