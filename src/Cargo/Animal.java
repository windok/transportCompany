package Cargo;

import Region.Region;

public class Animal extends Cargo {

    public Animal(int weight, Region region) {
        super(weight, region);
    }

    public String toString() {
        return "Animal: " + super.toString();
    }
}
