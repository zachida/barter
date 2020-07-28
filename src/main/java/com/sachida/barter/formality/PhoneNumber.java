package com.sachida.barter.formality;
import java.util.regex.Pattern;

/** Phone number validations. */
public class PhoneNumber {

    /**
     * The regex pattern for a country code.
     *
     * Optional plus sign, must start with a digit, may contain hyphens. At most 10 elements.
     *
     * Should accept +1, +54, +48, +1-787, +44-1234, +123-456789, +1234567890
     */
    public static final String COUNTRY_CODE_REGEX = "^\\+\\d[0-9\\-]{0,9}$";
    private static final Pattern COUNTRY_CODE = Pattern.compile(COUNTRY_CODE_REGEX);

    /**
     * The regex pattern for an area code.
     *
     * Up to 10 optional digits, no other symbols whatsoever.
     */
    public static final String AREA_CODE_REGEX = "^\\d{0,10}$";
    private static final Pattern AREA_CODE = Pattern.compile(AREA_CODE_REGEX);

    /**
     * The regex pattern for the subscriber number.
     *
     * From 4 to 10 digits, no other symbols whatsoever.
     */
    public static final String NUMBER_REGEX = "^\\d{4,10}$";
    private static final Pattern NUMBER = Pattern.compile(NUMBER_REGEX);

    /**
     * Validates a country code.
     *
     * @param countryCode country code
     */
    public static void validateCountryCode(String countryCode) {
        if (!COUNTRY_CODE.matcher(countryCode).matches())
            throw new EmailBadFormatException(ErrorCodes.INVALID_PHONE_COUNTRY_CODE);
    }

    /**
     * Validates an area code.
     *
     * @param areaCode area code
     */
    public static void validateAreaCode(String areaCode) {
        if (!AREA_CODE.matcher(areaCode).matches())
            throw new EmailBadFormatException(ErrorCodes.INVALID_PHONE_AREA_CODE);
    }

    /**
     * Validates a subscriber number.
     *
     * @param number phone number
     */
    public static void validateNumber(String number) {
        if (!NUMBER.matcher(number).matches())
            throw new EmailBadFormatException(ErrorCodes.INVALID_PHONE_NUMBER);
    }

}