package com.windok.Cargo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CargoPackage implements Iterable<Cargo> {

    private List<Cargo> cargoCollection;
    private int distance;
    private int totalWeight;

    public CargoPackage(int distance){
        cargoCollection = new ArrayList<>();
        setDistance(distance);
    }

    public void add(Cargo cargo) {
        cargoCollection.add(cargo);
        totalWeight += cargo.getWeight();
    }

    @Override
    public Iterator<Cargo> iterator() {
        return cargoCollection.iterator();
    }

    @Override
    public void forEach(Consumer<? super Cargo> action) {
        cargoCollection.forEach(action);
    }

    @Override
    public Spliterator<Cargo> spliterator() {
        return cargoCollection.spliterator();
    }

    public int getDistance() {
        return distance;
    }

    public CargoPackage setDistance(int distance) {
        this.distance = distance;
        return this;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "CargoPackage :" + cargoCollection;
    }
}
