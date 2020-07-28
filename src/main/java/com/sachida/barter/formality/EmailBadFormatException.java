package com.sachida.barter.formality;

import com.sachida.barter.rest.api.exception.BarterException;


public class EmailBadFormatException extends BarterException {

    EmailBadFormatException(String message) {
        super(message);
    }

}