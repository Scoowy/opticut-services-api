package com.opticortes.utils.responses;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.25.2335
 */
public class OkResponse extends BasicResponse {
    public OkResponse(int code, String message) {
        super(code, message, "OK");
    }
}
