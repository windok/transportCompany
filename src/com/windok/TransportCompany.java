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

    private TransportDepartment transportDepartment;

    public TransportCompany(TransportDepartment transportDepartment) {
        setTransportDepartment(transportDepartment);
    }

    public static void main(String args[]) throws Exception {

        CargoLoadingDepartment cargoLoadingDepartment = new CargoLoadingDepartment(new CargoBuilder());
        TransportDepartment transportDepartment = new TransportDepartment(cargoLoadingDepartment);

        TransportCompany transportCompany = new TransportCompany(transportDepartment);

        transportCompany.addTransportBuilder(TransportBuilder.instantiate(TransportType.CAR));
        transportCompany.addTransportBuilder(TransportBuilder.instantiate(TransportType.AIRCRAFT));
        transportCompany.addTransportBuilder(TransportBuilder.instantiate(TransportType.BOAT));

        transportCompany.buyTransport(Region.US);
        transportCompany.buyTransport(Region.EMEA);
        transportCompany.buyTransport(Region.APAC);

        new Thread(transportCompany).start();
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

    private TransportDepartment getTransportDepartment() {
        return transportDepartment;
    }

    private TransportCompany setTransportDepartment(TransportDepartment transportDepartment) {
        this.transportDepartment = transportDepartment;
        return this;
    }

}
