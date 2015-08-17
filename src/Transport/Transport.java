package Transport;

import Cargo.Cargo;
import Person.Employee;

public abstract class Transport {

    private int distanceWithoutRefuel;
    private String region;
    private Cargo cargo;
    private int capacity;
    private Employee driver;

    public Transport(String region, int distanceWithoutRefuel, int capacity, Employee driver) {
        this.setRegion(region).
                setDistanceWithoutRefuel(distanceWithoutRefuel).
                setCapacity(capacity).
                setDriver(driver)
        ;
    }

    protected abstract void arrive();
    protected abstract void refuel();
    protected abstract void leave();

    public void load(Cargo cargo) {
        this.setCargo(cargo);
    }

    public void deliver(int distance) {
        this.leave();

        int distanceToGo = distance;
        while (distanceToGo > this.getDistanceWithoutRefuel()) {
            distanceToGo -= this.getDistanceWithoutRefuel();
            this.refuel();
        }

        this.arrive();
    }

    public int getDistanceWithoutRefuel() {
        return distanceWithoutRefuel;
    }

    public Transport setDistanceWithoutRefuel(int distanceWithoutRefuel) {
        this.distanceWithoutRefuel = distanceWithoutRefuel;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Transport setRegion(String region) {
        this.region = region;
        return this;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Transport setCargo(Cargo cargo) {
        this.cargo = cargo;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public Transport setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Employee getDriver() {
        return driver;
    }

    public Transport setDriver(Employee driver) {
        this.driver = driver;
        return this;
    }
}
