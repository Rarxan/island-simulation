package com.javarush.rybalchenko.islandsimulation;

import com.javarush.rybalchenko.islandsimulation.engine.IslandEngine;
import com.javarush.rybalchenko.islandsimulation.map.Island;
import com.javarush.rybalchenko.islandsimulation.spawn.AnimalSpawner;
import com.javarush.rybalchenko.islandsimulation.spawn.PlantSpawner;

public class IslandGameLauncher {
    public static void run(){
        Island island = new Island(100, 20);

        new PlantSpawner(island).spawn();
        new AnimalSpawner(island).spawn();

        new IslandEngine(island).startSimulation();
    }
}
