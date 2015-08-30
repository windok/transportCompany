package com.windok.Transport;

public class Car extends Transport {

    public Car(int number, int distanceWithoutRefuel, int capacity, int speed) {
        super(number, distanceWithoutRefuel, capacity, speed);
    }

    protected void arrive() {
        System.out.println("Car " + getNumber() + " arrived to " + getRegion());
    }

    protected void refuel() {
        System.out.println("Car " + getNumber() + " was refueled");
    }

    protected void leave() {
        System.out.println("Car " + getNumber() + " leaved " + getRegion());
    }

    @Override
    public String toString() {
        return "Car " + super.toString();
    }
}
