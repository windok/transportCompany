package com.windok.Delivery;

import com.windok.Cargo.CargoPackage;
import com.windok.Departments.CargoLoadingDepartment;
import com.windok.Transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class Delivery implements Runnable, DeliveryObservable {

    private Transport transport;
    private CargoLoadingDepartment cargoLoadingDepartment;
    private List<DeliverySubject> observers;

    public Delivery(Transport transport, CargoLoadingDepartment cargoLoadingDepartment) {
        observers = new ArrayList<>();
        setTransport(transport);
        setCargoLoadingDepartment(cargoLoadingDepartment);

    }

    public void startDelivery() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Delivery starts");
        CargoPackage cargoPackage = getCargoLoadingDepartment().preparePackage(getTransport());
        try {
            getTransport().deliver(cargoPackage);
        } catch (InterruptedException exception) {}

        notifyObservers();
    }

    @Override
    public void addObserver(DeliverySubject deliverySubject) {
        observers.add(deliverySubject);
    }

    @Override
    public void notifyObservers() {
        for (DeliverySubject deliverySubject : observers) {
            deliverySubject.update(this);
        }
    }

    private Transport getTransport() {
        return transport;
    }

    private Delivery setTransport(Transport transport) {
        this.transport = transport;
        return this;
    }

    private CargoLoadingDepartment getCargoLoadingDepartment() {
        return cargoLoadingDepartment;
    }

    private Delivery setCargoLoadingDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
        this.cargoLoadingDepartment = cargoLoadingDepartment;
        return this;
    }
}
