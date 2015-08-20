package Transport;

import Person.Employee;

public class Boat extends Transport{

    public Boat(int number, String region, int distanceWithoutRefuel, int capacity, int speed, Employee employee) {
        super(number, region, distanceWithoutRefuel, capacity, speed, employee);
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
