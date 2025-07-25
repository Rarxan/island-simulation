package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;
import com.javarush.rybalchenko.islandsimulation.map.Location;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Fox extends Predator{

    public static final double WEIGHT = 8.0;
    public static final int MAX_IN_CELL = 30;
    public static final int MAX_SPEED = 2;
    public static final double FOOD_REQUIRED = 2.0;
    public static final int MOUSE_HUNT_SUCCESS_CHANCE = 90;

    private static Random random = new Random();

    public Fox() {
        super(WEIGHT, MAX_IN_CELL, MAX_SPEED, FOOD_REQUIRED);
    }

    @Override
    public void move() {
        animalMovingLogic();
        System.out.println(Emojis.FOX + " The fox is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.FOX + " The fox is reproducing");
    }

    @Override
    public void eat() {
        List<Animal> animals = currentLocation.getAnimals();

        synchronized (animals) {
            Iterator<Animal> iterator = animals.iterator();

            while (iterator.hasNext()) {
                Animal target = iterator.next();
                if (target instanceof Mouse && target.isAlive() && target!=this) {
                    if (random.nextInt(100) < MOUSE_HUNT_SUCCESS_CHANCE) {
                        iterator.remove();
                        target.alive = false;
                        this.addFood(target.weight);
                        System.out.println(Emojis.FOX + " The fox is ate a mouse...");
                        break;
                    }
                }
            }
        }

        System.out.println(Emojis.FOX + " The fox is eating");
    }
}
