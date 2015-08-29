package Builders.Transport;

import Builders.EmployeeBuilder;
import Builders.TransportBuilder;
import Transport.*;

public class BoatBuilder extends TransportBuilder{

    public BoatBuilder(EmployeeBuilder employeeBuilder) {
        super(employeeBuilder);
    }

    @Override
    protected Transport create() {
        return new Boat(getUniqueTransportNumber(), getDistanceWithoutRefuel(), getCapacity(), getSpeed());
    }
}
