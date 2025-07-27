package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Eagle extends Predator {

    public Eagle() {
        super(6.0, 20, 3, 1.0);
    }

    public String getEmoji(){
        return Emojis.EAGLE;
    }

    @Override
    public void move() {
        animalMovingLogic();
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.EAGLE + " Eagle is reproducing");
    }

    private static final Map<Class<? extends Animal>, Integer> HUNT_CHANCES = Map.ofEntries(
            Map.entry(Rabbit.class, 90),
            Map.entry(Mouse.class, 90),
            Map.entry(Duck.class, 80)

    );

    protected Map<Class<? extends Animal>, Integer> getHuntChances() {
        return HUNT_CHANCES;
    }
}
