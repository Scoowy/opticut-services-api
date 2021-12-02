package com.opticortes.controllers;

import spark.Request;
import spark.Response;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1636
 */
public interface ICRUDController {
//    Gson gson = new Gson();

    String getAll(Request req, Response res);

    String deleteAll(Request req, Response res);

    String addNew(Request req, Response res);

    String getOne(Request req, Response res);

    String updateOne(Request req, Response res);

    String deleteOne(Request req, Response res);
}
