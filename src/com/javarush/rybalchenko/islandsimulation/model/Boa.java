package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Boa extends Predator {

    public static final double WEIGHT = 15.0;
    public static final int MAX_IN_CELL = 30;
    public static final int MAX_SPEED = 1;
    public static final double FOOD_REQUIRED = 3.0;
    public static final int RABBIT_HUNT_SUCCESS_CHANCE = 20;

    public static final Random random = new Random();

    public Boa() {
        super(WEIGHT, MAX_IN_CELL, MAX_SPEED, FOOD_REQUIRED);
    }

    @Override
    public void move() {
        animalMovingLogic();
        System.out.println(Emojis.BOA + " Boa is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.BOA + " Boa is reproducing");
    }

    @Override
    public void eat() {
        List<Animal> animals = currentLocation.getAnimals();
        synchronized (animals) {
            Iterator<Animal> iterator = animals.iterator();
            while (iterator.hasNext()) {
                Animal target = iterator.next();
                if (target instanceof Rabbit && target.isAlive() && target != this) {
                    if (random.nextInt(100) < RABBIT_HUNT_SUCCESS_CHANCE) {
                        iterator.remove();
                        target.alive = false;
                        this.addFood(target.weight);
                        System.out.println(Emojis.BOA + " Boa ate a rabbit");
                        break;
                    }
                }
            }
        }
    }
}
