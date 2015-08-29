package Builders;

import Builders.Employee.*;
import Builders.Transport.*;
import Exceptions.NotDefinedTransportException;
import Transport.Transport;
import java.util.Random;

abstract public class TransportBuilder {

    public static final String TYPE_CAR = "Car";
    public static final String TYPE_AIRCRAFT = "Aircraft";
    public static final String TYPE_BOAT = "Boat";

    public static final int SPEED_MIN = 100;
    public static final int SPEED_MAX = 500;

    public static final int CAPACITY_MIN = 50;
    public static final int CAPACITY_MAX = 2500;

    public static final int DISTANCE_WITHOUT_REFUEL_MIN = 300;
    public static final int DISTANCE_WITHOUT_REFUEL_MAX = 2000;

    private EmployeeBuilder employeeBuilder;
    private Random rand = new Random();
    private int currentTransportNumber = 0;

    public TransportBuilder(EmployeeBuilder employeeBuilder) {
        setEmployeeBuilder(employeeBuilder);
    }

    public static TransportBuilder instantiate(String transportType) throws NotDefinedTransportException {
        switch (transportType) {
            case TYPE_CAR:
                return new CarBuilder(new DriverBuilder());
            case TYPE_AIRCRAFT:
                return new AircraftBuilder(new PilotBuilder());
            case TYPE_BOAT:
                return new BoatBuilder(new CaptainBuilder());
        }

        throw new NotDefinedTransportException();
    }

    abstract protected Transport create();

    public Transport buy(String region) {
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
        return rand.nextInt(SPEED_MAX - SPEED_MIN) + SPEED_MIN;
    }

    protected int getCapacity() {
        return rand.nextInt(CAPACITY_MAX - CAPACITY_MIN) + CAPACITY_MIN;
    }

    protected int getDistanceWithoutRefuel() {
        return rand.nextInt(DISTANCE_WITHOUT_REFUEL_MAX - DISTANCE_WITHOUT_REFUEL_MIN) + DISTANCE_WITHOUT_REFUEL_MIN;
    }
}