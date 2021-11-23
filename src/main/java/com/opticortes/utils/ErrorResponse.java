package com.opticortes.utils;

import java.util.StringJoiner;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.23.1804
 */
public class ErrorResponse {
    private int code;
    private String message;
    private final String status = "ERROR";

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ErrorResponse.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("message='" + message + "'")
                .add("status='" + status + "'")
                .toString();
    }
}
