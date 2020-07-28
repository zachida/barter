package com.sachida.barter.formality;

import java.util.regex.Pattern;

/** Email validation. */
public class Email {

    /**
     * This pattern has been taken verbatim from Play's validation library.
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9\\\\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    private static final Pattern EMAIL = Pattern.compile(EMAIL_REGEX);

    /**
     * Validates an email address.
     *
     * @param email email address
     */
    public static void validateEmail(String email) {
        if (!EMAIL.matcher(email).matches())
            throw new EmailBadFormatException(String.format("Invalid email address: %s", email));
    }

}