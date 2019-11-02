package com.sachida.barter.rest.controller;

import com.sachida.barter.rest.api.BarterErrorResponse;
import com.sachida.barter.rest.api.ErrorCode;
import com.sachida.barter.rest.api.exception.BarterAlreadyAUserException;
import com.sachida.barter.rest.api.exception.BarterBadRequestException;
import com.sachida.barter.rest.api.exception.BarterException;
import com.sachida.barter.rest.api.exception.BarterNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class BarterExceptionHandler {
    private static Logger LOGGER = LoggerFactory.getLogger(BarterExceptionHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BarterErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<String> errorMessage = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new BarterErrorResponse(ErrorCode.REQUEST_VALIDATION_ERROR, errorMessage.toString());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BarterErrorResponse handleConstraintViolation(ConstraintViolationException exception) {
        return new BarterErrorResponse(ErrorCode.BARTER_INTERNAL_ERROR, exception.toString());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BarterErrorResponse handleException(BarterNotFoundException exception) {
        return new BarterErrorResponse(ErrorCode.BARTER_NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public BarterErrorResponse handleException(BarterAlreadyAUserException exception) {
        return new BarterErrorResponse(ErrorCode.USER_ALREADY_EXISTS, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BarterErrorResponse handleAllExceptions(Exception exception) {
        logErrorWithSpace(exception.getMessage(), exception);
        return new BarterErrorResponse(ErrorCode.BARTER_INTERNAL_ERROR, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BarterErrorResponse handleBarterExceptions(BarterException exception) {
        logErrorWithSpace(exception.getMessage(), exception);
        return new BarterErrorResponse(ErrorCode.BARTER_INTERNAL_ERROR, exception.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BarterErrorResponse handleException(BarterBadRequestException exception) {
        LOGGER.error(exception.getMessage());
        return new BarterErrorResponse(ErrorCode.REQUEST_VALIDATION_ERROR, exception.getMessage());
    }

    private void logErrorWithSpace(String message, Exception exception) {
        LOGGER.error(message + " ", exception);
    }

}
