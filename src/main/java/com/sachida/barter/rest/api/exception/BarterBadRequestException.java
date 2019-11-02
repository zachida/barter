package com.sachida.barter.rest.api.exception;

public class BarterBadRequestException extends BarterException {
    public BarterBadRequestException(String message) {
        super(message);
    }
    public BarterBadRequestException(String message,Throwable e) {
        super(message,e);
    }
}
