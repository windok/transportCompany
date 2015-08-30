package com.windok;

import com.windok.Builders.CargoBuilder;
import com.windok.Builders.TransportBuilder;
import com.windok.Departments.CargoLoadingDepartment;
import com.windok.Departments.TransportDepartment;
import com.windok.Transport.Transport;
import com.windok.Transport.TransportType;

import java.util.ArrayList;
import java.util.Random;

public class TransportCompany implements Runnable {

    private ArrayList<TransportBuilder> transportBuilders = new ArrayList<>();
    private Random random = new Random();
    private Thread thread;

    private TransportDepartment transportDepartment;
    private CargoLoadingDepartment cargoLoadingDepartment;

    public TransportCompany(TransportDepartment transportDepartment, CargoLoadingDepartment cargoLoadingDepartment) {
        setTransportDepartment(transportDepartment);
        setCargoLoadingDepartment(cargoLoadingDepartment);
        setThread(new Thread(this));
    }

    public static void main(String args[]) throws Exception {

        CargoLoadingDepartment cargoLoadingDepartment = new CargoLoadingDepartment(new CargoBuilder());
        TransportDepartment transportDepartment = new TransportDepartment(cargoLoadingDepartment);

        TransportCompany transportCompany = new TransportCompany(transportDepartment, cargoLoadingDepartment);

        transportCompany.addTransportBuilder(TransportBuilder.instantiate(TransportType.CAR));
        transportCompany.addTransportBuilder(TransportBuilder.instantiate(TransportType.AIRCRAFT));
        transportCompany.addTransportBuilder(TransportBuilder.instantiate(TransportType.BOAT));

        transportCompany.buyTransport(Region.US);
        transportCompany.buyTransport(Region.EMEA);
        transportCompany.buyTransport(Region.APAC);

        transportCompany.getThread().start();

        cargoLoadingDepartment.getThread().join();
        transportCompany.getThread().join();

        for (int i = 0; i < Config.DAYS_BEFORE_VIRUS_COVERS_WHOLE_WORLD; i++) {
            System.out.println("New infection is covering the world...");
            Thread.sleep(1000);
        }

        System.out.println("BANG!!! COMPANY WAS DESTROYED AND ALL CUSTOMERS ARE NOT DIED!!! \nTHEY ARE WALKING DEAD!!!\nHA-HA-HA!!");
        System.out.println("\n\n try to build new world from Config...");
    }

    public void addTransportBuilder(TransportBuilder transportBuilder) {
        getTransportBuilders().add(transportBuilder);
    }

    public void buyTransport(Region region) {
        Transport transport = getTransportBuilders().get(getRandom().nextInt(getTransportBuilders().size())).buy(region);

        System.out.println("COMPANY IS RISING!! New transport was bought: " + transport);

        getTransportDepartment().addTransport(transport);
    }

    public void buyTransport() {
        buyTransport(Region.random());
    }

    @Override
    public void run() {
        for(int i = 0; i < Config.AMOUNT_OF_TRANSPORT_TO_BUY; i++) {
            try {
                Thread.sleep(Config.TIME_BEFORE_BUY_NEW_TRANSPORT);

                if (! getCargoLoadingDepartment().getThread().isAlive()){
                    break;
                }

                buyTransport();

            } catch (Exception exception) {}
        }
    }

    private ArrayList<TransportBuilder> getTransportBuilders() {
        return transportBuilders;
    }

    private Random getRandom() {
        return random;
    }

    private Thread getThread() {
        return thread;
    }

    private TransportCompany setThread(Thread thread) {
        this.thread = thread;
        return this;
    }

    private TransportDepartment getTransportDepartment() {
        return transportDepartment;
    }

    private TransportCompany setTransportDepartment(TransportDepartment transportDepartment) {
        this.transportDepartment = transportDepartment;
        return this;
    }

    private CargoLoadingDepartment getCargoLoadingDepartment() {
        return cargoLoadingDepartment;
    }

    private TransportCompany setCargoLoadingDepartment(CargoLoadingDepartment cargoLoadingDepartment) {
        this.cargoLoadingDepartment = cargoLoadingDepartment;
        return this;
    }
}
