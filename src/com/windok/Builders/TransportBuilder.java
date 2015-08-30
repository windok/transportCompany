package com.windok.Builders;

import com.windok.Builders.Employee.*;
import com.windok.Builders.Transport.*;
import com.windok.Config;
import com.windok.Exceptions.NotDefinedTransportException;
import com.windok.Region;
import com.windok.Transport.*;

import java.util.Random;

abstract public class TransportBuilder {

    private EmployeeBuilder employeeBuilder;
    private Random rand = new Random();
    private int currentTransportNumber = 0;

    public TransportBuilder(EmployeeBuilder employeeBuilder) {
        setEmployeeBuilder(employeeBuilder);
    }

    public static TransportBuilder instantiate(TransportType transportType) throws NotDefinedTransportException {
        switch (transportType) {
            case CAR:
                return new CarBuilder(new DriverBuilder());
            case AIRCRAFT:
                return new AircraftBuilder(new PilotBuilder());
            case BOAT:
                return new BoatBuilder(new CaptainBuilder());
        }

        throw new NotDefinedTransportException();
    }

    abstract protected Transport create();

    public Transport buy(Region region) {
        return create().
                setEmployee(getEmployeeBuilder().hire(region)).
                setRegion(region);
    }


    protected EmployeeBuilder getEmployeeBuilder() {
        return employeeBuilder;
    }

    protected TransportBuilder setEmployeeBuilder(EmployeeBuilder employeeBuilder) {
        this.employeeBuilder = employeeBuilder;
        return this;
    }

    protected int getUniqueTransportNumber() {
        return ++currentTransportNumber;
    }

    protected int getSpeed() {
        return rand.nextInt(Config.TRANSPORT_SPEED_MAX - Config.TRANSPORT_SPEED_MIN) + Config.TRANSPORT_SPEED_MIN;
    }

    protected int getCapacity() {
        return rand.nextInt(Config.TRANSPORT_CAPACITY_MAX - Config.TRANSPORT_CAPACITY_MIN) + Config.TRANSPORT_CAPACITY_MIN;
    }

    protected int getDistanceWithoutRefuel() {
        return rand.nextInt(Config.TRANSPORT_DISTANCE_WITHOUT_REFUEL_MAX - Config.TRANSPORT_DISTANCE_WITHOUT_REFUEL_MIN) + Config.TRANSPORT_DISTANCE_WITHOUT_REFUEL_MIN;
    }
}
