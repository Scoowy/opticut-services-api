package com.opticortes.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opticortes.utils.responses.ErrorResponse;
import com.opticortes.utils.ResponseType;
import spark.Request;
import spark.Response;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.12.07.2339
 */
public class GenericController {
    Gson gson;
    GsonBuilder builder = new GsonBuilder();

    public GenericController() {
        this.gson = builder.create();
    }

    public String resourceNotFound(Request req, Response res) {
        res.type(ResponseType.JSON.toString());
        return gson.toJson(new ErrorResponse(404, "Resource not found"));
    }

    public String unknownError(Request req, Response res) {
        res.type(ResponseType.JSON.toString());
        return gson.toJson(new ErrorResponse(500, "Unknown error, see the logs"));
    }
}
