package Transport;

import java.util.Random;

public enum TransportType {

    CAR,
    AIRCRAFT,
    BOAT;

    private static Random random = new Random();
    public static TransportType random()
    {
        return TransportType.values()[random.nextInt(TransportType.values().length)];
    }


}
