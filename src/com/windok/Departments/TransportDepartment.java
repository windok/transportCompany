package com.windok.Departments;

import com.windok.Delivery;
import com.windok.Transport.Transport;

import java.util.Observable;
import java.util.Observer;

public class TransportDepartment implements Observer {

    private CargoLoadingDepartment cargoLoadingDepartment;

    public TransportDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
        setCargoLoadingDepartment(cargoLoadingDepartment);
    }

    public TransportDepartment addTransport(Transport transport) {
        Delivery delivery = new Delivery(transport, getCargoLoadingDepartment());
        delivery.addObserver(this);
        return this;
    }

    @Override
    public void update(Observable o, Object arg) {
        Delivery delivery = (Delivery) o;
        delivery.start();
    }

    private CargoLoadingDepartment getCargoLoadingDepartment() {
        return cargoLoadingDepartment;
    }

    private TransportDepartment setCargoLoadingDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
        this.cargoLoadingDepartment = cargoLoadingDepartment;
        return this;
    }
}
