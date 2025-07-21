package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.List;

public class Caterpillar extends  Herbivore{
    public Caterpillar() {
        super(0.01, 1000, 0, 0);
    }

    @Override
    public void move() {
        System.out.println(Emojis.CATERPILLAR + " Caterpillar doesn't move");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.CATERPILLAR + " Caterpillar is reproducing");
    }

    @Override
    public void eat() {
        List<Plant> plants = currentLocation.getPlants();
        synchronized (plants) {
            if(!plants.isEmpty()) {
                plants.remove(0);
                addFood(1.0);
                System.out.println(Emojis.CATERPILLAR + " Caterpillar is eating a plants");
            }
        }
    }
}
