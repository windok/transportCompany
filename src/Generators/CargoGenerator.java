package Generators;

import Builders.CargoBuilder;
import Cargo.CargoType;
import Departments.CargoLoadingDepartment;
import Exceptions.NotDefinedCargoException;

import java.util.Random;

public class CargoGenerator implements Runnable {

    private Thread thread;
    private Random rand;
    private CargoLoadingDepartment cargoLoadingDepartment;
    private CargoBuilder cargoBuilder;

    public CargoGenerator(CargoLoadingDepartment cargoLoadingDepartment, CargoBuilder cargoBuilder) {
        setThread(new Thread(this)).
                setRand(new Random()).
                setCargoLoadingDepartment(cargoLoadingDepartment).
                setCargoBuilder(cargoBuilder);

        getThread().start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(getRand().nextInt(1000));
            } catch (InterruptedException exception) {
            }
            try {
                getCargoLoadingDepartment().addToLoadingQueue(getCargoBuilder().build(CargoType.random()));
            } catch (NotDefinedCargoException exception) {
            }
        }
    }

    private Thread getThread() {
        return thread;
    }

    private CargoGenerator setThread(Thread thread) {
        this.thread = thread;
        return this;
    }

    private Random getRand() {
        return rand;
    }

    private CargoGenerator setRand(Random rand) {
        this.rand = rand;
        return this;
    }

    private CargoLoadingDepartment getCargoLoadingDepartment() {
        return cargoLoadingDepartment;
    }

    private CargoGenerator setCargoLoadingDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
        this.cargoLoadingDepartment = cargoLoadingDepartment;
        return this;
    }

    private CargoBuilder getCargoBuilder() {
        return cargoBuilder;
    }

    private CargoGenerator setCargoBuilder(CargoBuilder cargoBuilder) {
        this.cargoBuilder = cargoBuilder;
        return this;
    }
}
