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

    private Set<Cargo> cargoSet;

    private boolean isInTransit;

    public Transport(int number, int distanceWithoutRefuel, int capacity, int speed) {
        setNumber(number);
        setDistanceWithoutRefuel(distanceWithoutRefuel);
        setCapacity(capacity);
        setSpeed(speed);
        setIsInTransit(false);
        unload();
    }

    protected abstract void arrive();

    protected abstract void refuel();

    protected abstract void leave();

    public final Transport load(Cargo cargo) throws OutOfSpaceException {

        if (cargo.getWeight() > getCapacity() - getLoadedSpace()) {
            throw new OutOfSpaceException();
        }

        getCargoSet().add(cargo);

        return this;
    }

    public final Transport unload() {
        setLoadedSpace(0);
        setCargoSet(new HashSet<>());

        return this;
    }

    public final void deliver(int distance) throws InterruptedException {
        setIsInTransit(true);
        leave();
        getEmployee().doJob();

        int distanceToGo = distance;

        while (distanceToGo > getDistanceWithoutRefuel()) {
            goDistance(getDistanceWithoutRefuel());
            distanceToGo -= getDistanceWithoutRefuel();
            refuel();
        }

        goDistance(distanceToGo);

        arrive();
        setIsInTransit(false);
        unload();
    }

    private void goDistance(int distance) throws InterruptedException {
        int timeToGo = (int) (distance * 1f / getSpeed() * 1000);
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

    public Set<Cargo> getCargoSet() {
        return cargoSet;
    }

    public Transport setCargoSet(Set<Cargo> cargoSet) {
        this.cargoSet = cargoSet;
        return this;
    }

    public boolean isInTransit() {
        return isInTransit;
    }

    private Transport setIsInTransit(boolean isInTransit) {
        this.isInTransit = isInTransit;
        return this;
    }

    public String toString() {

        String cargoDescription = "";

        for (Cargo cargo : getCargoSet()) {
            cargoDescription += cargo.toString();
        }

        if (cargoDescription.equals("")) {
            cargoDescription = "NO CARGO";
        }

        return "number - " + getNumber() + "; region - " + getRegion() + "; cargo - " + cargoDescription + "; empty space - " + (getCapacity() - getLoadedSpace());
    }
}
