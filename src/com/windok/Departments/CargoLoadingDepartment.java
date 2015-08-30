package com.windok.Departments;

import com.windok.Builders.CargoBuilder;
import com.windok.Cargo.Cargo;
import com.windok.Cargo.CargoPackage;
import com.windok.Cargo.CargoType;
import com.windok.Exceptions.NotDefinedCargoException;
import com.windok.Transport.Transport;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class CargoLoadingDepartment implements Runnable {

    private Set<Cargo> loadingQueue = new TreeSet<>();
    private Random random = new Random();
    private CargoBuilder cargoBuilder;

    public CargoLoadingDepartment(CargoBuilder cargoBuilder) {
        setCargoBuilder(cargoBuilder);
        new Thread(this).start();
    }

    public void addToLoadingQueue(Cargo cargo) {
        getLoadingQueue().add(cargo);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException exception) {
            }
            try {
                this.addToLoadingQueue(getCargoBuilder().build(CargoType.random()));
            } catch (NotDefinedCargoException exception) {
            }
        }
    }


    synchronized public CargoPackage preparePackage(Transport transport) {
        CargoPackage cargoPackage = new CargoPackage(random.nextInt(5000));

        Iterator<Cargo> iterator = getLoadingQueue().iterator();

        while (iterator.hasNext()) {
            Cargo cargo = iterator.next();
            if (transport.getRegion() == cargo.getRegion()) {
                if (transport.getCapacity() >= cargoPackage.getTotalWeight() + cargo.getWeight()) {
                    cargoPackage.add(cargo);
                    iterator.remove();
                } else {
                    break;
                }
            }
        }

        return cargoPackage;
    }

    private Set<Cargo> getLoadingQueue() {
        return loadingQueue;
    }

    private CargoBuilder getCargoBuilder() {
        return cargoBuilder;
    }

    private CargoLoadingDepartment setCargoBuilder(CargoBuilder cargoBuilder) {
        this.cargoBuilder = cargoBuilder;
        return this;
    }
}
