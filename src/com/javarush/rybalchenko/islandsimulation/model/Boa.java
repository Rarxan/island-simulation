package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Boa extends Predator {

    public static final Random random = new Random();

    public Boa() {
        super(15.0, 30, 1, 3.0);
    }

    @Override
    public void move() {
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
                    if (random.nextInt(100) < 20) {
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
