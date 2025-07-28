package com.javarush.rybalchenko.islandsimulation.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Predator extends Animal {
    public Predator(double weight, int maxCount, int speed, double foodRequired) {
        super(weight, maxCount, speed, foodRequired);
    }

    protected static final Random random = new Random();
    protected abstract Map<Class<? extends Animal>, Integer> getHuntChances();

    @Override
    public void eat(){
        List<Animal> animals = currentLocation.getAnimals();
        Map<Class<? extends Animal>, Integer> huntChances = getHuntChances();

        synchronized (animals) {
            Iterator<Animal> it = animals.iterator();
            while (it.hasNext()) {
                Animal target = it.next();
                if(target !=this && target.isAlive()){
                    Integer chance = huntChances.get(target.getClass());
                    if(chance != null && random.nextInt(100) < chance){
                        it.remove();
                        target.alive = false;
                        addFood(target.weight);
                        System.out.printf("%s %s ate a %s!%n", getEmoji(), getClass().getSimpleName(),target.getClass().getSimpleName());
                        if (foodEaten>=foodRequired){
                            break;
                        }
                    }
                }
            }
        }
    }
}
