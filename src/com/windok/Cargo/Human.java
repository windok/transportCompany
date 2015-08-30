package com.windok.Cargo;

import com.windok.Region;

public class Human extends Cargo {

    public Human(int weight, Region region) {
        super(weight, region);
    }

    public String toString() {
        return "Human: " + super.toString();
    }
}
