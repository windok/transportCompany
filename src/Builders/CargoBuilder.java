package Builders;

import Cargo.*;
import Exceptions.NotDefinedCargoException;
import Region.Region;

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
