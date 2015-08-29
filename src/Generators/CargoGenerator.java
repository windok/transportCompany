//package Generators;
//
//import Departments.CargoLoadingDepartment;
//
//import java.util.Random;
//
//public class CargoGenerator implements Runnable {
//
//    private Thread thread;
//    private Random rand;
//    private CargoLoadingDepartment cargoLoadingDepartment;
//
//    public CargoGenerator(CargoLoadingDepartment cargoLoadingDepartment) {
//        setThread(new Thread(this)).setRand(new Random()).setCargoLoadingDepartment(cargoLoadingDepartment);
//        getThread().start();
//    }
//
//    @Override
//    public void run() {
//        int customerWaitTime = getRand().nextInt(1000);
//        getCargoLoadingDepartment().addToLoadingQueue();
//    }
//
//    private Thread getThread() {
//        return thread;
//    }
//
//    private CargoGenerator setThread(Thread thread) {
//        this.thread = thread;
//        return this;
//    }
//
//    private Random getRand() {
//        return rand;
//    }
//
//    private CargoGenerator setRand(Random rand) {
//        this.rand = rand;
//        return this;
//    }
//
//    private CargoLoadingDepartment getCargoLoadingDepartment() {
//        return cargoLoadingDepartment;
//    }
//
//    private CargoGenerator setCargoLoadingDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
//        this.cargoLoadingDepartment = cargoLoadingDepartment;
//        return this;
//    }
//}
