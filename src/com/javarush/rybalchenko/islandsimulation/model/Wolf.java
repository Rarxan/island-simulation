package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;
import com.javarush.rybalchenko.islandsimulation.map.Location;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Wolf extends Predator {

    public static final double WEIGHT = 6.0;
    public static final int MAX_IN_CELL = 20;
    public static final int MAX_SPEED = 3;
    public static final double FOOD_REQUIRED = 1.0;
    public static final int RABBIT_HUNT_SUCCESS_CHANCE = 70;

    private static Random random = new Random();

    public Wolf() {
        super(50.0, 30, 3, 8.0);
    }

    @Override
    public void move() {
        animalMovingLogic();
        System.out.println(Emojis.WOLF + " Wolf is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.WOLF + " Wolf is reproducing");
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
                        System.out.println(Emojis.WOLF + " Wolf ate a rabbit!");
                        break;
                    }
                }
            }
        }
        //System.out.println(Emojis.WOLF + " Wolf is eating");
    }
}
