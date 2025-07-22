package com.javarush.rybalchenko.islandsimulation.map;

import java.util.ArrayList;

public class Island {
    private final Location[][] map;

    public Island(int width, int height) {
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
}
