package com.windok.Person;

import java.util.Random;

public enum Qualification {

    FIRST {
        @Override
        public int getDriverSalary() {
            return 500;
        }

        @Override
        public int getPilotSalary() {
            return 1500;
        }

        @Override
        public int getCaptainSalary() {
            return 1350;
        }
    },
    SECOND {
        @Override
        public int getDriverSalary() {
            return 540;
        }

        @Override
        public int getPilotSalary() {
            return 1800;
        }

        @Override
        public int getCaptainSalary() {
            return 1600;
        }
    },
    THIRD {
        @Override
        public int getDriverSalary() {
            return 700;
        }

        @Override
        public int getPilotSalary() {
            return 2500;
        }

        @Override
        public int getCaptainSalary() {
            return 2400;
        }
    },
    FORTH {
        @Override
        public int getDriverSalary() {
            return 800;
        }

        @Override
        public int getPilotSalary() {
            return 3200;
        }

        @Override
        public int getCaptainSalary() {
            return 3200;
        }
    },
    FIFTH {
        @Override
        public int getDriverSalary() {
            return 950;
        }

        @Override
        public int getPilotSalary() {
            return 4000;
        }

        @Override
        public int getCaptainSalary() {
            return 4200;
        }
    };

    abstract public int getDriverSalary();
    abstract public int getPilotSalary();
    abstract public int getCaptainSalary();


    private static Random random = new Random();
    public static Qualification random() {
        return Qualification.values()[random.nextInt(Qualification.values().length)];
    }

}
