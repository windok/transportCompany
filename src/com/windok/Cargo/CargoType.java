package com.windok.Cargo;

import com.windok.Config;
import java.util.Random;

public enum CargoType {

    HUMAN {
        @Override
        public int getWeight() {
            return random.nextInt(Config.CARGO_WEIGHT_HUMAN_MAX - Config.CARGO_WEIGHT_HUMAN_MIN) + Config.CARGO_WEIGHT_HUMAN_MIN;
        }
    },
    ANIMAL {
        @Override
        public int getWeight() {
            return random.nextInt(Config.CARGO_WEIGHT_ANIMAL_MAX - Config.CARGO_WEIGHT_ANIMAL_MIN) + Config.CARGO_WEIGHT_ANIMAL_MIN;
        }
    },
    THING {
        @Override
        public int getWeight() {
            return random.nextInt(Config.CARGO_WEIGHT_THING_MAX - Config.CARGO_WEIGHT_THING_MIN) + Config.CARGO_WEIGHT_THING_MIN;
        }
    };

    abstract public int getWeight();

    private static Random random = new Random();

    public static CargoType random() {
        return CargoType.values()[random.nextInt(CargoType.values().length)];
    }

}
