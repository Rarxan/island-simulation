package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Fox extends Predator{

    public Fox() {
        super(8.0, 30, 2, 2.0);
    }
    public String getEmoji(){
        return Emojis.FOX;
    }

    @Override
    public void move() {
        animalMovingLogic();
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.FOX + " The fox is reproducing");
    }

    private static final Map<Class<? extends Animal>, Integer> HUNT_CHANCES = Map.ofEntries(
            Map.entry(Rabbit.class, 70),
            Map.entry(Mouse.class, 90),
            Map.entry(Duck.class, 60),
            Map.entry(Caterpillar.class, 40)
    );

    protected Map<Class<? extends Animal>, Integer> getHuntChances() {
        return HUNT_CHANCES;
    }
}
