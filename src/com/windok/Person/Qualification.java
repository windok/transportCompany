package com.windok.Person;

import java.util.Random;

public enum Qualification {

    FIRST {
        @Override
        public int getDriverSalary() {
            return 0;
        }

        @Override
        public int getPilotSalary() {
            return 0;
        }

        @Override
        public int getCaptainSalary() {
            return 0;
        }
    },
    SECOND {
        @Override
        public int getDriverSalary() {
            return 0;
        }

        @Override
        public int getPilotSalary() {
            return 0;
        }

        @Override
        public int getCaptainSalary() {
            return 0;
        }
    },
    THIRD {
        @Override
        public int getDriverSalary() {
            return 0;
        }

        @Override
        public int getPilotSalary() {
            return 0;
        }

        @Override
        public int getCaptainSalary() {
            return 0;
        }
    },
    FORTH {
        @Override
        public int getDriverSalary() {
            return 0;
        }

        @Override
        public int getPilotSalary() {
            return 0;
        }

        @Override
        public int getCaptainSalary() {
            return 0;
        }
    },
    FIFTH {
        @Override
        public int getDriverSalary() {
            return 0;
        }

        @Override
        public int getPilotSalary() {
            return 0;
        }

        @Override
        public int getCaptainSalary() {
            return 0;
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
