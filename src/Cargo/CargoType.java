package Cargo;

import java.util.Random;

public enum CargoType {

    HUMAN,
    ANIMAL,
    THING;

    private static Random random = new Random();

    public static CargoType random()
    {
        return CargoType.values()[random.nextInt(CargoType.values().length + 1)];
    }


}
