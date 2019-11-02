package com.sachida.barter.rest.api.exception;

public class BarterException extends RuntimeException {

    public BarterException(Throwable cause) {
        super("Barter internal error. ", cause);
    }

    public BarterException(String message) {
        super(message);
    }

    public BarterException(String message, Throwable cause) {
        super(message, cause);
    }
}
