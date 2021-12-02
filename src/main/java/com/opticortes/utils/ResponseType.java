package com.opticortes.utils;

import java.util.StringJoiner;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1647
 */
public enum ResponseType {
    JSON("application/json"),
    HTML("text/html");

    private final String type;

    ResponseType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
