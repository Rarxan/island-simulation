package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Wolf extends Predator {

    private static Random random = new Random();

    public Wolf() {
        super(50.0, 30, 3, 8.0);
    }

    @Override
    public void move() {
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
                    iterator.remove();
                    target.alive = false;
                    this.addFood(target.weight);
                    System.out.println(Emojis.WOLF + " Wolf ate a rabbit!");
                }
            }
        }
        System.out.println(Emojis.WOLF + " Wolf is eating");
    }
}
