package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.ArrayList;
import java.util.List;

public class Deer extends Herbivore {
    public Deer() {
        super(300.0, 20, 4, 50.0);
    }

    @Override
    public void move() {
        animalMovingLogic();
        System.out.println(Emojis.DEER + " Deer is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.DEER + " Deer is reproducing");
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
            System.out.println(Emojis.DEER + " Deer is eating " + needToEat + " plants");
        }

    }
}
