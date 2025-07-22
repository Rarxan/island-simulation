package com.javarush.rybalchenko.islandsimulation;

import com.javarush.rybalchenko.islandsimulation.engine.IslandEngine;
import com.javarush.rybalchenko.islandsimulation.map.Island;
import com.javarush.rybalchenko.islandsimulation.spawn.AnimalSpawner;
import com.javarush.rybalchenko.islandsimulation.spawn.PlantSpawner;
import static com.javarush.rybalchenko.islandsimulation.constants.IslandConfig.*;

public class IslandGameLauncher {
    public static void run() {

        Island island = new Island(ISLAND_WIDTH,ISLAND_HEIGHT);

        new PlantSpawner(island).spawn();
        new AnimalSpawner(island).spawn();

        new IslandEngine(island).startSimulation();
    }
}
