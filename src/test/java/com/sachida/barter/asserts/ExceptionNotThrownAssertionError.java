package com.sachida.barter.asserts;

class ExceptionNotThrownAssertionError extends AssertionError {
    ExceptionNotThrownAssertionError() {
        super("Expected exception was not thrown.");
    }
}