package Exceptions;

public class NoFreeTransportException extends Exception{

    public final static String DEFAULT_MESSAGE = "There is no free transport!";

    public NoFreeTransportException() {
        super(DEFAULT_MESSAGE);
    }

}
