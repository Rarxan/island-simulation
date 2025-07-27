package com.javarush.rybalchenko.islandsimulation.engine;

import com.javarush.rybalchenko.islandsimulation.map.Island;
import com.javarush.rybalchenko.islandsimulation.map.Location;
import com.javarush.rybalchenko.islandsimulation.model.Animal;
import com.javarush.rybalchenko.islandsimulation.model.Plant;

import java.util.ArrayList;
import java.util.Iterator;
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
                List<Animal> animalCopy;

                synchronized (location.getAnimals()) {
                    animalCopy = new ArrayList<>(location.getAnimals());
                }

                for (Iterator<Animal> iterator = animalCopy.iterator();
                     iterator.hasNext(); ) {
                    Animal animal = iterator.next();

                    if (!animal.isAlive()) {
                        iterator.remove();
                        continue;
                    }
                    animal.setCurrentLocation(location);
                    executor.submit(() -> {
                        animal.liveCyсle();
                    });
                }
            }
        }
        executor.shutdown();
    }
    public void growPlants(){
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location location = island.getLocation(x, y);
                location.addPlant(new Plant());
            }
        }
    }

}

