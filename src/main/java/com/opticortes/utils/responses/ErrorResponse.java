package com.opticortes.utils.responses;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.23.1804
 */
public class ErrorResponse extends BasicResponse {
    public ErrorResponse(int code, String message) {
        super(code, message, "ERROR");
    }
}
