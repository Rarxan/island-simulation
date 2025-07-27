package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Bear extends Predator {

    public static final double WEIGHT = 500.0;
    public static final int MAX_IN_CELL = 5;
    public static final int MAX_SPEED = 2;
    public static final double FOOD_REQUIRED = 80.0;
    public static final int RABBIT_HUNT_SUCCESS_CHANCE = 80;
    public static final int MOUSE_HUNT_SUCCESS_CHANCE = 90;

    private static Random random = new Random();

    public Bear() {
        super(WEIGHT, MAX_IN_CELL, MAX_SPEED, FOOD_REQUIRED);
    }

    public String getEmoji() {
        return Emojis.BEAR;
    }

    @Override
    public void move() {
        animalMovingLogic();
        //System.out.println(Emojis.BEAR + " A bear is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.BEAR + " The bear is reproducing");
    }

    @Override
    public void eat() {

        List<Animal> animals = currentLocation.getAnimals();
        synchronized (animals) {
            Iterator<Animal> iterator = animals.iterator();

            while (iterator.hasNext()) {
                Animal target = iterator.next();
                if (target != this && target.isAlive()) {
                    if (target instanceof Rabbit && random.nextInt(100)<RABBIT_HUNT_SUCCESS_CHANCE) {
                        iterator.remove();
                        target.alive = false;
                        this.addFood(target.weight);
                        System.out.println(Emojis.BEAR + " Bear ate a rabbit!");
                        break;
                    }
                    if (target instanceof Mouse && random.nextInt(100)<MOUSE_HUNT_SUCCESS_CHANCE) {
                        iterator.remove();
                        target.alive = false;
                        this.addFood(target.weight);
                        System.out.println(Emojis.BEAR + " Bear ate a mouse!");
                        break;
                    }
                }
            }
        }
        System.out.println(Emojis.BEAR + " The bear is eating");
    }
}
