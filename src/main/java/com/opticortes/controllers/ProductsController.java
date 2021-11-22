package com.opticortes.controllers;

import com.opticortes.utils.ResponseType;
import spark.Request;
import spark.Response;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1607
 */
public class ProductsController implements ICRUDController{

    @Override
    public String getAll(Request req, Response res) {
        res.type(ResponseType.JSON.toString());
        return gson.toJson("Obteniendo todas las planchas");
    }

    @Override
    public String deleteAll(Request req, Response res) {
        return null;
    }

    @Override
    public String addNew(Request req, Response res) {
        return null;
    }

    @Override
    public String getOne(Request req, Response res) {
        return null;
    }

    @Override
    public String updateOne(Request req, Response res) {
        return null;
    }

    @Override
    public String deleteOne(Request req, Response res) {
        return null;
    }
}
