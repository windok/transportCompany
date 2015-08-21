package Transport;

import Person.Employee;

public class Car extends Transport {

    public Car(int number, int distanceWithoutRefuel, int capacity, int speed) {
        super(number, distanceWithoutRefuel, capacity, speed);
    }

    protected void arrive() {
        System.out.println("Car arrived to end point. Details: " + this);
    }

    protected void refuel() {
        System.out.println("Car was refueled. Details: " + this);
    }

    protected void leave() {
        System.out.println("Car leaved the start point. Details: " + this);
    }
}
