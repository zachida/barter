package com.sachida.barter.formality;

import com.sachida.barter.rest.api.exception.BarterException;


public class PhoneNumberBadFormatException extends BarterException {

    PhoneNumberBadFormatException(String message) {
        super(message);
    }

}