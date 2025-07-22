package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Bear extends Predator {

    private static Random random = new Random();

    public Bear() {
        super(500.0, 5, 2, 80.0);
    }

    @Override
    public void move() {
        System.out.println(Emojis.BEAR + " A bear is moving");
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
                    if (target instanceof Rabbit && random.nextInt(100)<80) {
                        iterator.remove();
                        target.alive = false;
                        this.addFood(target.weight);
                        System.out.println(Emojis.BEAR + " Bear ate a rabbit!");
                        break;
                    }
                    if (target instanceof Mouse && random.nextInt(100)<90) {
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
