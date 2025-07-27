package com.javarush.rybalchenko.islandsimulation.map;

import java.util.ArrayList;

public class Island {

    private final int width;
    private final int height;

    private final Location[][] map;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Location[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = new Location();
            }
        }
    }

    public Location[][] getMap() {
        return map;
    }

    public Location getLocation(int x, int y) {
        return map[y][x];
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
