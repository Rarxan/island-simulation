package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Wolf extends Predator {

    public Wolf() {
        super(50.0, 30, 3, 8.0);
    }
    public String getEmoji(){
        return Emojis.WOLF;
    }

    @Override
    public void move() {
        animalMovingLogic();
    }

    @Override
    public void reproduce() {
        System.out.println(Emojis.WOLF + " Wolf is reproducing");
    }

    private static final Map<Class<? extends Animal>, Integer> HUNT_CHANCES = Map.ofEntries(
            Map.entry(Rabbit.class, 60),
            Map.entry(Mouse.class, 80),
            Map.entry(Goat.class, 60),
            Map.entry(Sheep.class, 70),
            Map.entry(Boar.class, 15),
            Map.entry(Buffalo.class, 10),
            Map.entry(Duck.class, 40)
    );

    protected Map<Class<? extends Animal>, Integer> getHuntChances() {
        return HUNT_CHANCES;
    }
}
