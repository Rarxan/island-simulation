package com.javarush.rybalchenko.islandsimulation.spawn;

import com.javarush.rybalchenko.islandsimulation.map.Island;
import com.javarush.rybalchenko.islandsimulation.map.Location;
import com.javarush.rybalchenko.islandsimulation.model.Plant;

public class PlantSpawner {
    private final Island island;

    public PlantSpawner(Island island) {
        this.island = island;
    }

    public void spawn() {
        Location[][] map = island.getMap();

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                for (int i = 0; i < 100; i++) {
                    map[y][x].addPlant(new Plant());
                }
            }
        }
        System.out.println("\uD83C\uDF3F All locations populated with plants");
    }
}
