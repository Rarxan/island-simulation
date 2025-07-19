package com.javarush.rybalchenko.islandsimulation.spawn;

import com.javarush.rybalchenko.islandsimulation.map.Island;
import com.javarush.rybalchenko.islandsimulation.map.Location;
import com.javarush.rybalchenko.islandsimulation.model.*;

public class AnimalSpawner {

    private final Island island;

    public AnimalSpawner(Island island) {
        this.island = island;
    }

    public void spawn() {
        Location[][] map = island.getMap();

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                Location location = map[y][x];

                location.addAnimal(new Wolf());
                location.addAnimal(new Bear());
                location.addAnimal(new Horse());
                location.addAnimal(new Rabbit());
                location.addAnimal(new Fox());
                location.addAnimal(new Mouse());
            }
        }
        System.out.println("\uD83E\uDD81 Animals populated the island");
    }


}
