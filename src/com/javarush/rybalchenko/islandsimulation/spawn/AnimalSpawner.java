package com.javarush.rybalchenko.islandsimulation.spawn;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;
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


                addAnimalLocation(new Wolf(),x, y, location);
                addAnimalLocation(new Bear(),x, y, location);
                addAnimalLocation(new Horse(),x, y, location);
                addAnimalLocation(new Rabbit(),x, y, location);
                addAnimalLocation(new Fox(),x, y, location);
                addAnimalLocation(new Mouse(),x, y, location);
                addAnimalLocation(new Caterpillar(),x, y, location);
                addAnimalLocation(new Eagle(),x, y, location);
                addAnimalLocation(new Boa(),x, y, location);
                addAnimalLocation(new Deer(),x, y, location);
                addAnimalLocation(new Sheep(),x, y, location);
                addAnimalLocation(new Boar(),x, y, location);
                addAnimalLocation(new Duck(),x, y, location);
                addAnimalLocation(new Buffalo(),x, y, location);
                addAnimalLocation(new Goat(),x, y, location);

            }
        }
        System.out.println(Emojis.ANIMALS + " Animals populated the island");
    }

    public void addAnimalLocation (Animal animal, int x, int y, Location location) {
        animal.setCoordinates(x,y);
        animal.setIsland(island);
        animal.setCurrentLocation(location);
        location.addAnimal(animal);
    }
}