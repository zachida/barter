package com.sachida.barter.formality;

import org.junit.Test;

import static com.sachida.barter.asserts.ValidationAssertion.assertValidation;

public class EmailTest {

    @Test
    public void emailAddressValid() {
        Email.validateEmail("a@b.com");
    }

    @Test
    public void emailAddressMissingUser() {
        assertValidation(() -> Email.validateEmail("@b.com")).hasCode(ErrorCodes.INVALID_EMAIL_ADDRESS);
    }

    @Test
    public void emailAddressMissingHost() {
        assertValidation(() -> Email.validateEmail("a@")).hasCode(ErrorCodes.INVALID_EMAIL_ADDRESS);
    }

    @Test
    public void emailAddressInvalidChars() {
        assertValidation(() -> Email.validateEmail("ñandú@pingüino.com.ar")).hasCode(ErrorCodes.INVALID_EMAIL_ADDRESS);
    }
}
