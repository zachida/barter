package com.sachida.barter.asserts;

@FunctionalInterface
public interface ExceptionThrower {
    void throwException() throws Throwable;
}