package com.javarush.rybalchenko.islandsimulation.model;

import com.javarush.rybalchenko.islandsimulation.constants.Emojis;
import com.javarush.rybalchenko.islandsimulation.map.Island;
import com.javarush.rybalchenko.islandsimulation.map.Location;

public abstract class Animal {

    protected double weight;
    protected int maxCount;
    protected int speed;
    protected double foodRequired;
    protected double foodEaten = 0;
    protected boolean alive = true;

    protected int x;
    protected int y;
    protected Island island;
    protected Location currentLocation;

    public Animal(double weight, int maxCount, int speed, double foodRequired) {
        this.weight = weight;
        this.maxCount = maxCount;
        this.speed = speed;
        this.foodRequired = foodRequired;
    }


    public void liveCyсle() {

        eat();
        move();
        reproduce();

        if (foodEaten < foodRequired) {
            alive = false;
            System.out.printf("%s %s has starved to death at (%d %d)%n", Emojis.DEATH, getClass().getSimpleName(), x, y);
            //System.out.println(getClass().getSimpleName() + " is starving!");
        } else {
            foodEaten = 0;
        }
    }

    public void addFood(double amount) {
        foodEaten += amount;
    }

    public void setCurrentLocation(Location location) {
        this.currentLocation = location;
    }

    public boolean isAlive() {
        return alive;
    }

    public abstract void move();

    public abstract void reproduce();

    public abstract void eat();

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setIsland(Island island) {
        this.island = island;
    }

    protected int[] getNewCoordinates() {
        int dx = (int) (Math.random() * (speed * 2 + 1)) - speed;
        int dy = (int) (Math.random() * (speed * 2 + 1)) - speed;

        int newX = x + dx;
        int newY = y + dy;

        newX = Math.max(0, Math.min(newX, island.getMap()[0].length - 1));
        newY = Math.max(0, Math.min(newY, island.getMap().length - 1));

        return new int[]{newX, newY};
    }

    public void animalMovingLogic() {
        int oldX = x;
        int oldY = y;

        int[] newCoordinates = getNewCoordinates();
        int newX = newCoordinates[0];
        int newY = newCoordinates[1];

        if (newX == oldX && newY == oldY) {
            return;
        }

        Location oldLocation = island.getLocation(oldX, oldY);
        Location newLocation = island.getLocation(newX, newY);

        synchronized (oldLocation) {
            synchronized (newLocation) {
                oldLocation.getAnimals().remove(this);
                setCoordinates(newX, newY);
                newLocation.addAnimal(this);
                setCurrentLocation(newLocation);
            }
        }
        System.out.printf("%s %s moved from (%d %d) to (%d %d)%n", getEmoji(),getClass().getSimpleName(), oldX, oldY, newX, newY);
    }

    public String getEmoji(){
        return "";
    }

}
