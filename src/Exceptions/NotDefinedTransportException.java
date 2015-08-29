package Exceptions;

public class NotDefinedTransportException extends Exception {

    public final static String DEFAULT_MESSAGE = "Not defined transport!";

    public NotDefinedTransportException() {
        super(DEFAULT_MESSAGE);
    }

}
