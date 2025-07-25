package com.javarush.rybalchenko.islandsimulation.map;

import com.javarush.rybalchenko.islandsimulation.model.Animal;
import com.javarush.rybalchenko.islandsimulation.model.Plant;
import com.javarush.rybalchenko.islandsimulation.model.Wolf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Location {
    private final List<Animal> animals = Collections.synchronizedList(new ArrayList<>());
    private final List<Plant> plants = Collections.synchronizedList(new ArrayList<>());

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
    }

}
