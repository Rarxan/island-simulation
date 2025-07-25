package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(2.0, 150, 2, 0.45);
    }

    @Override
    public void move() {
        animalMovingLogic();
        System.out.println(Emojis.RABBIT + " Rabbit is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.RABBIT + " Rabbit is reproducing");
    }

    @Override
    public void eat() {
        List<Plant> plants = currentLocation.getPlants();

        synchronized (plants) {
            if (!plants.isEmpty()) {
                plants.remove(0);
                addFood(1.0);
                System.out.println(Emojis.RABBIT + " Rabbit is eating a plant!");
            }
        }
    }
}
