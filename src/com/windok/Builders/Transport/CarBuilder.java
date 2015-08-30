package com.windok.Builders.Transport;

import com.windok.Builders.EmployeeBuilder;
import com.windok.Builders.TransportBuilder;
import com.windok.Transport.*;

public class CarBuilder extends TransportBuilder {

    public CarBuilder(EmployeeBuilder employeeBuilder) {
        super(employeeBuilder);
    }

    @Override
    protected Transport create() {
        return new Car(getUniqueTransportNumber(), getDistanceWithoutRefuel(), getCapacity(), getSpeed());
    }


}
