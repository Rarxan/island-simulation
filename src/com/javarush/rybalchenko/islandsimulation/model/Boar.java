package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.List;

public class Boar extends Herbivore {
    public Boar() {
        super(400.0, 50, 2, 50.0);
    }

    public String getEmoji() {
        return Emojis.BOAR;
    }

    @Override
    public void move() {
        animalMovingLogic();
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.BOAR + " Boar is reproduing");
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
            System.out.println(Emojis.BOAR + " Boar is eating " + needToEat + " plants");
        }
    }
}
