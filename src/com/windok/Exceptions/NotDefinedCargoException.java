package com.windok.Exceptions;

public class NotDefinedCargoException extends Exception {

    public final static String DEFAULT_MESSAGE = "Not defined cargo!";

    public NotDefinedCargoException() {
        super(DEFAULT_MESSAGE);
    }

}
