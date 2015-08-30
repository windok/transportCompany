package com.windok.Transport;

public class Aircraft extends Transport{

    public Aircraft(int number, int distanceWithoutRefuel, int capacity, int speed) {
        super(number, distanceWithoutRefuel, capacity, speed);
    }

    protected void arrive() {
        System.out.println("Aircraft arrived to end point. Details: " + this);
    }

    protected void refuel() {
        System.out.println("Aircraft was refueled. Details: " + this);
    }

    protected void leave() {
        System.out.println("Aircraft leaved the start point. Details: " + this);
    }
}
