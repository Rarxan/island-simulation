package com.javarush.rybalchenko.islandsimulation.engine;

import com.javarush.rybalchenko.islandsimulation.map.Island;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandEngine {
    private final Island island;
    private final ScheduledExecutorService scheduler;

    public IslandEngine(Island island) {
        this.island = island;
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startSimulation() {
        scheduler.scheduleAtFixedRate(this::runCycle, 0, 1, TimeUnit.SECONDS);
    }

    private void runCycle() {
        System.out.println("\uD83C\uDF0D Running island simulation");
    }
}
