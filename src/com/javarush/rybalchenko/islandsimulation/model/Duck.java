package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;

public class Duck extends Herbivore {
    public Duck() {
        super(1.0, 200, 4, 0.15);
    }

    @Override
    public void move() {
        animalMovingLogic();
        System.out.println(Emojis.DUCK + " Duck is moving");
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.DUCK + " Duck is reproducing");
    }

    @Override
    public void eat() {
        boolean ate = false;

        List<Plant> plants = currentLocation.getPlants();
        synchronized (plants) {
            int needToEat = (int) Math.min(foodRequired - foodEaten, plants.size());
            for (int i = 0; i < needToEat; i++) {
                plants.remove(0);
                addFood(1.0);
                ate = true;
            }
            if (ate) {
                System.out.println(Emojis.DUCK + " Duck is eating " + needToEat + " plants");
            }
        }

        if (!ate) {
            List<Animal> animals = currentLocation.getAnimals();
            synchronized (animals) {
                Iterator<Animal> iterator = animals.iterator();
                while (iterator.hasNext()) {
                    Animal target = iterator.next();
                    if (target instanceof Caterpillar && target.isAlive() && target != this) {
                        iterator.remove();
                        target.alive = false;
                        this.addFood(target.weight);
                        System.out.println(Emojis.DUCK + " Duck ate caterpillar");
                        break;
                    }
                }
            }
        }
    }
}
