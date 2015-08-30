package com.windok.Builders;

import com.windok.Cargo.*;
import com.windok.Exceptions.NotDefinedCargoException;
import com.windok.Region;

public class CargoBuilder {

    public Cargo build(CargoType cargoType) throws NotDefinedCargoException {
        switch (cargoType) {
            case HUMAN:
                return new Human(cargoType.getWeight(), Region.random());
            case ANIMAL:
                return new Animal(cargoType.getWeight(), Region.random());
            case THING:
                return new Thing(cargoType.getWeight(), Region.random());
        }

        throw new NotDefinedCargoException();
    }

}
