package Exceptions;

public class OutOfSpaceException extends Exception {

    public final static String DEFAULT_MESSAGE = "Out of space!";

    public OutOfSpaceException() {
        super(DEFAULT_MESSAGE);
    }

}
