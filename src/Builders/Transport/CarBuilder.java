package Builders.Transport;

import Builders.EmployeeBuilder;
import Builders.TransportBuilder;
import Transport.*;

public class CarBuilder extends TransportBuilder {

    public CarBuilder(EmployeeBuilder employeeBuilder) {
        super(employeeBuilder);
    }

    @Override
    protected Transport create() {
        return new Car(getUniqueTransportNumber(), getDistanceWithoutRefuel(), getCapacity(), getSpeed());
    }


}
