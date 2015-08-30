package com.windok;

import java.util.Random;

public enum Region {

    US,
    EMEA,
    APAC;

    private static Random random = new Random();

    public static Region random() {
        return Region.values()[random.nextInt(Region.values().length)];
    }

}
