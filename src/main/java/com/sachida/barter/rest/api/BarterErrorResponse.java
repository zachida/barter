package com.sachida.barter.rest.api;

import java.io.Serializable;

public class BarterErrorResponse implements Serializable {

    private ErrorCode code;
    private String message;


    public BarterErrorResponse(ErrorCode code, String message) {
        this.code = code;
        this.message = message;
    }


    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
