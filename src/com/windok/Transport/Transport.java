package com.windok.Transport;

import com.windok.Cargo.CargoPackage;
import com.windok.Person.Employee;
import com.windok.Region;

public abstract class Transport {

    private int number;
    private Region region;
    private int distanceWithoutRefuel;
    private int capacity;
    private int speed;
    private Employee employee;

    public Transport(int number, int distanceWithoutRefuel, int capacity, int speed) {
        setNumber(number);
        setDistanceWithoutRefuel(distanceWithoutRefuel);
        setCapacity(capacity);
        setSpeed(speed);
    }

    protected abstract void arrive();

    protected abstract void refuel();

    protected abstract void leave();

    public final void deliver(CargoPackage cargoPackage) throws InterruptedException {
        getEmployee().doJob();
        leave();

        printDeliveryMessage(cargoPackage);

        int distanceToGo = cargoPackage.getDistance();

        while (distanceToGo > getDistanceWithoutRefuel()) {
            goDistance(getDistanceWithoutRefuel());
            distanceToGo -= getDistanceWithoutRefuel();
            refuel();
        }

        goDistance(distanceToGo);

        arrive();
    }

    private void printDeliveryMessage(CargoPackage cargoPackage) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.
                append("Capacity - ").append(getCapacity()).
                append(". Package weight - ").append(cargoPackage.getTotalWeight()).
                append(". Distance without refuel - ").append(getDistanceWithoutRefuel()).
                append(". Distance to go - ").append(cargoPackage.getDistance()).
                append(". Speed - ").append(getSpeed()).
                append("\n").append(cargoPackage);

        System.out.println(stringBuilder);
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

    public Region getRegion() {
        return region;
    }

    public Transport setRegion(Region region) {
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

    @Override
    public String toString() {
        return getNumber() + ", capacity - " + getCapacity() + ", distance without refuel - " + getDistanceWithoutRefuel() + ", speed - " + getSpeed();
    }
}
