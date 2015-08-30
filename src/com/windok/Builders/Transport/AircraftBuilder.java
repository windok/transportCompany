package com.windok.Builders.Transport;

import com.windok.Builders.EmployeeBuilder;
import com.windok.Builders.TransportBuilder;
import com.windok.Transport.*;

public class AircraftBuilder extends TransportBuilder{

    public AircraftBuilder(EmployeeBuilder employeeBuilder) {
        super(employeeBuilder);
    }

    @Override
    protected Transport create() {
        return new Aircraft(getUniqueTransportNumber(), getDistanceWithoutRefuel(), getCapacity(), getSpeed());
    }
}
