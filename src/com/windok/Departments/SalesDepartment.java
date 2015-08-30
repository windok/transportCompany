package com.windok.Departments;

import com.windok.Builders.TransportBuilder;
import com.windok.Region;
import com.windok.Transport.Transport;

import java.util.ArrayList;
import java.util.Random;

public class SalesDepartment implements Runnable {

    private ArrayList<TransportBuilder> transportBuilders;
    private Random random;

    private TransportDepartment transportDepartment;

    public SalesDepartment(TransportDepartment transportDepartment) {
        setTransportDepartment(transportDepartment);

        setTransportBuilders(new ArrayList<>());
        setRandom(new Random());

        new Thread(this).start();
    }

    public void addTransportBuilder(TransportBuilder transportBuilder) {
        getTransportBuilders().add(transportBuilder);
    }

    public void buyTransport(Region region) {
        getTransportDepartment().addTransport(getTransportBuilders().get(getRandom().nextInt(getTransportBuilders().size())).buy(region));
    }

    public void buyTransport() {
        buyTransport(Region.random());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            buyTransport();
        } catch (Exception exception) {}
    }

    private TransportDepartment getTransportDepartment() {
        return transportDepartment;
    }

    private SalesDepartment setTransportDepartment(TransportDepartment transportDepartment) {
        this.transportDepartment = transportDepartment;
        return this;
    }

    private ArrayList<TransportBuilder> getTransportBuilders() {
        return transportBuilders;
    }

    private SalesDepartment setTransportBuilders(ArrayList<TransportBuilder> transportBuilders) {
        this.transportBuilders = transportBuilders;
        return this;
    }

    private Random getRandom() {
        return random;
    }

    private SalesDepartment setRandom(Random random) {
        this.random = random;
        return this;
    }
}
