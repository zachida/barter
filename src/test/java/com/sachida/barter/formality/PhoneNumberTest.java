package com.sachida.barter.formality;

import org.junit.Test;

public class PhoneNumberTest {

    @Test
    public void validCountryCode() {
        PhoneNumber.validateCountryCode("+1");
        PhoneNumber.validateCountryCode("+54");
        PhoneNumber.validateCountryCode("+48");
        PhoneNumber.validateCountryCode("+1-787");
        PhoneNumber.validateCountryCode("+44-1234");
        PhoneNumber.validateCountryCode("+123-456789");
        PhoneNumber.validateCountryCode("+1234567890");
    }

    @Test
    public void countryCodeTooLong() {
        assertValidation(() -> PhoneNumber.validateCountryCode("+12345678901")).hasCode(ErrorCodes.INVALID_PHONE_COUNTRY_CODE);
    }

    @Test
    public void countryCodeTooShort() {
        assertValidation(() -> PhoneNumber.validateCountryCode("+")).hasCode(ErrorCodes.INVALID_PHONE_COUNTRY_CODE);
    }

    @Test
    public void countryCodeMissingPlusSign() {
        assertValidation(() -> PhoneNumber.validateCountryCode("123")).hasCode(ErrorCodes.INVALID_PHONE_COUNTRY_CODE);
    }

    @Test
    public void countryCodeNotNumbers() {
        assertValidation(() -> PhoneNumber.validateCountryCode("+1x")).hasCode(ErrorCodes.INVALID_PHONE_COUNTRY_CODE);
    }

    @Test
    public void countryCodeWithSpace() {
        assertValidation(() -> PhoneNumber.validateCountryCode("+1465 ")).hasCode(ErrorCodes.INVALID_PHONE_COUNTRY_CODE);
    }

    @Test
    public void validAreaCode() {
        PhoneNumber.validateAreaCode("1");
        PhoneNumber.validateAreaCode("1234567890");
    }

    @Test
    public void areaCodeOptional() {
        PhoneNumber.validateAreaCode("");
    }

    @Test
    public void areaCodeTooLong() {
        assertValidation(() -> PhoneNumber.validateAreaCode("12345678901")).hasCode(ErrorCodes.INVALID_PHONE_AREA_CODE);
    }

    @Test
    public void areaCodeNotNumbers() {
        assertValidation(() -> PhoneNumber.validateAreaCode("1x")).hasCode(ErrorCodes.INVALID_PHONE_AREA_CODE);
    }

    @Test
    public void areaCodeWithSpace() {
        assertValidation(() -> PhoneNumber.validateAreaCode("14564 ")).hasCode(ErrorCodes.INVALID_PHONE_AREA_CODE);
    }

    @Test
    public void validNumber() {
        PhoneNumber.validateNumber("1234");
        PhoneNumber.validateNumber("1234567890");
    }

    @Test

    public void numberTooShort() {
        assertValidation(() -> PhoneNumber.validateNumber("123")).hasCode(ErrorCodes.INVALID_PHONE_NUMBER);
    }

    @Test
    public void numberTooLong() {
        assertValidation(() -> PhoneNumber.validateNumber("12345678901")).hasCode(ErrorCodes.INVALID_PHONE_NUMBER);
    }

    @Test
    public void numberNotNumbers() {
        assertValidation(() -> PhoneNumber.validateNumber("1x")).hasCode(ErrorCodes.INVALID_PHONE_NUMBER);
    }

    @Test
    public void numberWithSpace() {
        assertValidation(() -> PhoneNumber.validateNumber("1465 ")).hasCode(ErrorCodes.INVALID_PHONE_NUMBER);
    }

}