package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.List;

public class Horse extends Herbivore {
    public Horse() {
        super(400.0, 20, 4, 60.0);
    }

    @Override
    public void move() {
        animalMovingLogic();
        System.out.println(Emojis.HORSE + " Horse is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.HORSE + " Horse is reproducing");
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
            System.out.println(Emojis.HORSE + " Horse is eating " + needToEat + " plants");
        }
    }
}
