package com.windok;

import com.windok.Cargo.CargoPackage;
import com.windok.Departments.CargoLoadingDepartment;
import com.windok.Transport.Transport;

public class Delivery extends java.util.Observable implements Runnable {

    private Thread thread;
    private Transport transport;
    private CargoLoadingDepartment cargoLoadingDepartment;

    public Delivery(Transport transport, CargoLoadingDepartment cargoLoadingDepartment) {
        setThread(new Thread(this));
        setTransport(transport);
        setCargoLoadingDepartment(cargoLoadingDepartment);

        setChanged();
        notifyObservers();
    }

    public void start() {
        getThread().start();
    }

    @Override
    public void run() {
        CargoPackage cargoPackage = cargoLoadingDepartment.preparePackage(getTransport());
        try {
            getTransport().deliver(cargoPackage);
        } catch (InterruptedException exception) {}

        setChanged();
        notifyObservers();
    }

    private Thread getThread() {
        return thread;
    }

    private Delivery setThread(Thread thread) {
        this.thread = thread;
        return this;
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
