package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Boa extends Predator {

    public Boa() {
        super(15.0, 30, 1, 3.0);
    }

    public String getEmoji(){
        return Emojis.BOA;
    }

    @Override
    public void move() {
        animalMovingLogic();
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.BOA + " Boa is reproducing");
    }

    private static final Map<Class<? extends Animal>, Integer> HUNT_CHANCES = Map.ofEntries(
            Map.entry(Rabbit.class, 20),
            Map.entry(Mouse.class, 40)
    );

    protected Map<Class<? extends Animal>, Integer> getHuntChances() {
        return HUNT_CHANCES;
    }
}
