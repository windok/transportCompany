package com.windok.Cargo;

import com.windok.Region;

public class Thing extends Cargo {

    public Thing(int weight, Region region) {
        super(weight, region);
    }

    public String toString() {
        return "Thing: " + super.toString();
    }
}
