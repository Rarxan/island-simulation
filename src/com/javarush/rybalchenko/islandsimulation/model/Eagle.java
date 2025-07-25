package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Eagle extends Predator {

    public static final double WEIGHT = 6.0;
    public static final int MAX_IN_CELL = 20;
    public static final int MAX_SPEED = 3;
    public static final double FOOD_REQUIRED = 1.0;
    public static final int MOUSE_HUNT_SUCCESS_CHANCE = 90;

    private static final Random random = new Random();

    public Eagle() {
        super(WEIGHT, MAX_IN_CELL, MAX_SPEED, FOOD_REQUIRED);
    }

    @Override
    public void move() {
        animalMovingLogic();
        System.out.println(Emojis.EAGLE + " Eagle is flying");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.EAGLE + " Eagle is reproducing");
    }

    @Override
    public void eat() {
        List<Animal> animals = currentLocation.getAnimals();
        synchronized (animals) {
            Iterator<Animal> iterator = animals.iterator();
            while (iterator.hasNext()) {
                Animal target = iterator.next();
                if (target instanceof Mouse && target.isAlive() && target != this) {
                    if (random.nextInt(100) < MOUSE_HUNT_SUCCESS_CHANCE) {
                        iterator.remove();
                        target.alive = false;
                        this.addFood(target.weight);
                        System.out.println(Emojis.EAGLE + " Eagle ate a mouse");
                        break;
                    }
                }
            }
        }
    }
}
