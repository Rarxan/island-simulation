package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Fox extends Predator{

    private static Random random = new Random();

    public Fox() {
        super(8.0, 30, 2, 2.0);
    }

    @Override
    public void move() {
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
                    if (random.nextInt(100) < 90) {
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
