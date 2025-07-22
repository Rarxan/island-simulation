package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.List;

public class Mouse extends Herbivore {
    public Mouse() {
        super(0.05, 500, 1, 0.01);
    }

    @Override
    public void move() {
        System.out.println(Emojis.MOUSE + " The mouse is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.MOUSE + " The mouse is reproducing");
    }

    @Override
    public void eat() {
        List<Plant> plants = currentLocation.getPlants();
        synchronized (plants) {
            int needToEat = (int) Math.min((foodRequired - foodEaten) / 1.0, plants.size());

            for (int i = 0; i < needToEat; i++) {
                plants.remove(0);
                addFood(1.0);
            }
            System.out.println(Emojis.MOUSE + " The mouse is eating " + needToEat + " plants");
        }
    }
}
