package Transport;

import Person.Employee;

public class Car extends Transport {

    public Car(int number, String region, int distanceWithoutRefuel, int capacity, int speed, Employee employee) {
        super(number, region, distanceWithoutRefuel, capacity, speed, employee);
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
