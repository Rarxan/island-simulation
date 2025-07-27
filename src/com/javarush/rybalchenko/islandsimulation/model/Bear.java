package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.*;

public class Bear extends Predator {

    public Bear() {
        super(500.0, 5, 2, 80.0);
    }

    public String getEmoji(){
        return Emojis.BEAR;
    }

    @Override
    public void move() {
        animalMovingLogic();
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.BEAR + " The bear is reproducing");
    }

    private static final Map<Class<? extends Animal>, Integer> HUNT_CHANCES = Map.ofEntries(
            Map.entry(Rabbit.class, 80),
            Map.entry(Mouse.class, 90),
            Map.entry(Deer.class, 80),
            Map.entry(Goat.class, 70),
            Map.entry(Sheep.class, 70),
            Map.entry(Boar.class, 50),
            Map.entry(Buffalo.class, 20),
            Map.entry(Duck.class, 10)
    );

    protected Map<Class<? extends Animal>, Integer> getHuntChances() {
        return HUNT_CHANCES;
    }
}
