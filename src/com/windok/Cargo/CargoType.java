package com.windok.Cargo;

import java.util.Random;

public enum CargoType {

    HUMAN {
        @Override
        public int getWeight() {
            return random.nextInt(Weight.HUMAN_MAX - Weight.HUMAN_MIN) - Weight.HUMAN_MIN;
        }
    },
    ANIMAL {
        @Override
        public int getWeight() {
            return random.nextInt(Weight.ANIMAL_MAX - Weight.ANIMAL_MIN) - Weight.ANIMAL_MIN;
        }
    },
    THING {
        @Override
        public int getWeight() {
            return random.nextInt(Weight.THING_MAX - Weight.THING_MIN) - Weight.THING_MIN;
        }
    };

    abstract public int getWeight();

    private static Random random = new Random();

    public static CargoType random() {
        return CargoType.values()[random.nextInt(CargoType.values().length)];
    }

    private static class Weight {
        private static final int HUMAN_MAX = 150;
        private static final int HUMAN_MIN = 50;

        private static final int ANIMAL_MAX = 150;
        private static final int ANIMAL_MIN = 50;

        private static final int THING_MAX = 150;
        private static final int THING_MIN = 50;

    }
}
