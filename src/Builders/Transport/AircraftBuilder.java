package Builders.Transport;

import Builders.EmployeeBuilder;
import Builders.TransportBuilder;
import Transport.*;

public class AircraftBuilder extends TransportBuilder{

    public AircraftBuilder(EmployeeBuilder employeeBuilder) {
        super(employeeBuilder);
    }

    @Override
    protected Transport create() {
        return new Aircraft(getUniqueTransportNumber(), getDistanceWithoutRefuel(), getCapacity(), getSpeed());
    }
}
