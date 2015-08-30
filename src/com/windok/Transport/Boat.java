package com.windok.Transport;

public class Boat extends Transport{

    public Boat(int number, int distanceWithoutRefuel, int capacity, int speed) {
        super(number, distanceWithoutRefuel, capacity, speed);
    }

    protected void arrive() {
        System.out.println("Boat " + getNumber() + " arrived to " + getRegion());
    }

    protected void refuel() {
        System.out.println("Boat " + getNumber() + " was refueled");
    }

    protected void leave() {
        System.out.println("Boat " + getNumber() + " leaved " + getRegion());
    }

    @Override
    public String toString() {
        return "Boat " + super.toString();
    }
}
