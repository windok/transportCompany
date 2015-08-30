package com.windok;

import com.windok.Builders.CargoBuilder;
import com.windok.Builders.TransportBuilder;
import com.windok.Departments.CargoLoadingDepartment;
import com.windok.Departments.TransportDepartment;
import com.windok.Transport.TransportType;

public class TransportCompany {

    public static void main(String args[]) throws Exception {

        CargoLoadingDepartment cargoLoadingDepartment = new CargoLoadingDepartment(new CargoBuilder());
        TransportDepartment transportDepartment = new TransportDepartment(cargoLoadingDepartment);

        TransportBuilder carBuilder = TransportBuilder.instantiate(TransportType.CAR);
        TransportBuilder aircraftBuilder = TransportBuilder.instantiate(TransportType.AIRCRAFT);
        TransportBuilder boatBuilder = TransportBuilder.instantiate(TransportType.BOAT);

        transportDepartment.
                addTransport(carBuilder.buy(Region.random())).
                addTransport(carBuilder.buy(Region.random())).
                addTransport(aircraftBuilder.buy(Region.random())).
                addTransport(aircraftBuilder.buy(Region.random())).
                addTransport(boatBuilder.buy(Region.random())).
                addTransport(boatBuilder.buy(Region.random()))
        ;

    }
}
