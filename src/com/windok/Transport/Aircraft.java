package com.windok.Transport;

public class Aircraft extends Transport {

    public Aircraft(int number, int distanceWithoutRefuel, int capacity, int speed) {
        super(number, distanceWithoutRefuel, capacity, speed);
    }

    protected void arrive() {
        System.out.println("Aircraft " + getNumber() + " arrived to " + getRegion());
    }

    protected void refuel() {
        System.out.println("Aircraft " + getNumber() + " was refueled");
    }

    protected void leave() {
        System.out.println("Aircraft " + getNumber() + " leaved " + getRegion());
    }

    @Override
    public String toString() {
        return "Aircraft " + super.toString();
    }
}
