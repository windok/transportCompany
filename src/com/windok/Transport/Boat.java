package com.windok.Transport;

public class Boat extends Transport{

    public Boat(int number, int distanceWithoutRefuel, int capacity, int speed) {
        super(number, distanceWithoutRefuel, capacity, speed);
    }

    protected void arrive() {
        System.out.println("Boat arrived to end point. Details: " + this);
    }

    protected void refuel() {
        System.out.println("Boat was refueled. Details: " + this);
    }

    protected void leave() {
        System.out.println("Boat leaved the start point. Details: " + this);
    }

}
