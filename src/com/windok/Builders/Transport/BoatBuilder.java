package com.windok.Builders.Transport;

import com.windok.Builders.EmployeeBuilder;
import com.windok.Builders.TransportBuilder;
import com.windok.Transport.*;

public class BoatBuilder extends TransportBuilder{

    public BoatBuilder(EmployeeBuilder employeeBuilder) {
        super(employeeBuilder);
    }

    @Override
    protected Transport create() {
        return new Boat(getUniqueTransportNumber(), getDistanceWithoutRefuel(), getCapacity(), getSpeed());
    }
}
