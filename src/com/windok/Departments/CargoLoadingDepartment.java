package com.windok.Departments;

import com.windok.Builders.CargoBuilder;
import com.windok.Cargo.Cargo;
import com.windok.Cargo.CargoPackage;
import com.windok.Cargo.CargoType;
import com.windok.Config;
import com.windok.Transport.Transport;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class CargoLoadingDepartment implements Runnable {

    private Thread thread;
    private Set<Cargo> loadingQueue = new TreeSet<>();
    private Random random = new Random();
    private CargoBuilder cargoBuilder;

    public CargoLoadingDepartment(CargoBuilder cargoBuilder) {
        setCargoBuilder(cargoBuilder);

        setThread(new Thread(this));
        getThread().start();
    }

    public void addToLoadingQueue(Cargo cargo) {
        getLoadingQueue().add(cargo);
    }

    @Override
    public void run() {
        for (int i = 0; i < Config.AMOUNT_OF_CARGO_TO_GENERATE; i++) {
            try {
                Thread.sleep(random.nextInt(Config.MAX_TIME_OF_NEW_CARGO_FROM_CUSTOMER_WAITING));
                addToLoadingQueue(getCargoBuilder().build(CargoType.random()));
            } catch (Exception exception) {
            }
        }
    }


    synchronized public CargoPackage preparePackage(Transport transport) {
        CargoPackage cargoPackage = new CargoPackage(random.nextInt(Config.MAX_DISTANCE_OF_CARGO_DELIVERING));

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

    public boolean isEmptyCargoQueue() {
        return getLoadingQueue().isEmpty();
    }

    public Thread getThread() {
        return thread;
    }

    private CargoLoadingDepartment setThread(Thread thread) {
        this.thread = thread;
        return this;
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
