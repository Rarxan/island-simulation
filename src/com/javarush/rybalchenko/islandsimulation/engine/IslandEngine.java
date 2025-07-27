package com.javarush.rybalchenko.islandsimulation.engine;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;
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
        LifeCycleTask task = new LifeCycleTask(island);
        task.run();
        task.growPlants();
        System.out.println(Emojis.ISLAND + " Running island simulation");
    }
}
