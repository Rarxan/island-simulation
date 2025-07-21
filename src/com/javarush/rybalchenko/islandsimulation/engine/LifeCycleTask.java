package com.javarush.rybalchenko.islandsimulation.engine;

import com.javarush.rybalchenko.islandsimulation.map.Island;
import com.javarush.rybalchenko.islandsimulation.map.Location;
import com.javarush.rybalchenko.islandsimulation.model.Animal;
import com.javarush.rybalchenko.islandsimulation.spawn.AnimalSpawner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LifeCycleTask {
    private final Island island;

    public LifeCycleTask(Island island) {
        this.island = island;
    }

    public void run() {
        Location[][] map = island.getMap();
        ExecutorService executor = Executors.newFixedThreadPool(8);

        for (Location[] row : map) {
            for (Location location : row) {
                List<Animal> animals = location.getAnimals();

                synchronized (animals) {
                    for (Animal animal : animals) {
                        executor.submit(()->animal.liveCykle());
                    }
                }
            }
        }
        executor.shutdown();
    }
}
