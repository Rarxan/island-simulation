package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Eagle extends Predator {

    private static final Random random = new Random();

    public Eagle() {
        super(6.0, 20, 3, 1.0);
    }

    @Override
    public void move() {
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
                    if (random.nextInt(100) < 90) {
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
