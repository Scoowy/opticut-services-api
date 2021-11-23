package com.opticortes.controllers;

import com.opticortes.services.PlanksServices;
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
        PlanksServices planksServices = new PlanksServices();
        res.type(ResponseType.JSON.toString());
        return gson.toJson(planksServices.getPlanks());
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
