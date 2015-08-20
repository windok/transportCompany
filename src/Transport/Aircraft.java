package Transport;

import Person.Employee;

public class Aircraft extends Transport{

    public Aircraft(int number, String region, int distanceWithoutRefuel, int capacity, int speed, Employee employee) {
        super(number, region, distanceWithoutRefuel, capacity, speed, employee);
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
