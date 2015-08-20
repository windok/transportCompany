package Transport;

import Cargo.Cargo;
import Exceptions.OutOfSpaceException;
import Person.Employee;

import java.util.HashSet;
import java.util.Set;

public abstract class Transport {

    private int number;
    private String region;
    private int distanceWithoutRefuel;
    private int capacity;
    private int loadedSpace;
    private int speed;
    private Employee employee;

    private Set<Cargo> cargo;

    public Transport(int number, String region, int distanceWithoutRefuel, int capacity, int speed, Employee employee) {
        this.setNumber(number).
                setRegion(region).
                setDistanceWithoutRefuel(distanceWithoutRefuel).
                setCapacity(capacity).
                setEmployee(employee).
                setSpeed(speed).
                unload()
        ;
    }

    protected abstract void arrive();

    protected abstract void refuel();

    protected abstract void leave();

    public final Transport load(Cargo cargo) throws OutOfSpaceException {

        if (cargo.getWeight() > this.getCapacity() - this.getLoadedSpace()) {
            throw new OutOfSpaceException();
        }

        this.cargo.add(cargo);

        return this;
    }

    public final Transport unload() {
        this.setLoadedSpace(0);
        this.setCargo(new HashSet<>());

        return this;
    }

    public final void deliver(int distance) throws InterruptedException {

        this.leave();

        this.getEmployee().doJob();

        int distanceToGo = distance;

        while (distanceToGo > this.getDistanceWithoutRefuel()) {
            this.goDistance(this.getDistanceWithoutRefuel());
            distanceToGo -= this.getDistanceWithoutRefuel();
            this.refuel();
        }

        this.goDistance(distanceToGo);

        this.arrive();
        this.unload();
    }

    private void goDistance(int distance) throws InterruptedException {
        int timeToGo = (int) (distance * 1f / this.getSpeed() * 1000);
        Thread.sleep(timeToGo);
    }

    public int getNumber() {
        return number;
    }

    public Transport setNumber(int number) {
        this.number = number;
        return this;
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

    public int getCapacity() {
        return capacity;
    }

    public Transport setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getSpeed() {
        return speed;
    }

    public Transport setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public Transport setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public int getLoadedSpace() {
        return loadedSpace;
    }

    public Transport setLoadedSpace(int loadedSpace) {
        this.loadedSpace = loadedSpace;
        return this;
    }

    public Set<Cargo> getCargo() {
        return cargo;
    }

    public Transport setCargo(Set<Cargo> cargo) {
        this.cargo = cargo;
        return this;
    }

    public String toString() {

        String cargoDescription = "";

        for (Cargo cargo : this.getCargo()) {
            cargoDescription += cargo.toString();
        }

        if (cargoDescription.equals("")) {
            cargoDescription = "NO CARGO";
        }

        return "number - " + this.getNumber() + "; region - " + this.getRegion() + "; cargo - " + cargoDescription + "; empty space - " + (this.getCapacity() - this.getLoadedSpace());
    }
}
