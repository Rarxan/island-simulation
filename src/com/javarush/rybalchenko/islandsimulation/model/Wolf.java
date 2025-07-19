package com.javarush.rybalchenko.islandsimulation.model;

public class Wolf extends Predator{

    public Wolf(){
        super(50.0, 30,3, 8.0);
    }

    @Override
    public void move() {
        System.out.println("\uD83D\uDC3A Wolf is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("\uD83D\uDC3A Wolf is reproducing");
    }

    @Override
    public void eat() {
        System.out.println("\uD83D\uDC3A Wolf is eating");
    }


}
