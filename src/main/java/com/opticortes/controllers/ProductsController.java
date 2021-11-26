package com.opticortes.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opticortes.api.OptiCutServicesAPI;
import com.opticortes.dao.PlankAdapter;
import com.opticortes.entities.Plank;
import com.opticortes.services.PlanksServices;
import com.opticortes.utils.ErrorResponse;
import com.opticortes.utils.OkResponse;
import com.opticortes.utils.ResponseType;
import spark.Request;
import spark.Response;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1607
 */
public class ProductsController implements ICRUDController {

    Gson gson;
    GsonBuilder builder = new GsonBuilder();
    PlanksServices planksServices = new PlanksServices();

    public ProductsController() {
        builder.registerTypeAdapter(Plank.class, new PlankAdapter());
        gson = builder.create();
    }

    @Override
    public String getAll(Request req, Response res) {
        res.type(ResponseType.JSON.toString());
        return gson.toJson(planksServices.getPlanks());
    }

    @Override
    public String deleteAll(Request req, Response res) {
        res.type(ResponseType.JSON.toString());

        int rowsAffected = planksServices.deletePlanks();

        if (rowsAffected != 0) {
            res.status(201);
            return gson.toJson(new OkResponse(201, "Deleted %d planks".formatted(rowsAffected)));
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Planks not deleted"));
        }
    }

    @Override
    public String addNew(Request req, Response res) {
        res.type(ResponseType.JSON.toString());

        String body = req.body();
        Plank plank = gson.fromJson(body, Plank.class);

        OptiCutServicesAPI.logger.info("[New Plank]: {}", plank);

        int rowsAffected = planksServices.addNewPlank(plank);

        if (rowsAffected != 0) {
            res.status(201);
            return gson.toJson(new OkResponse(201, "Plank created"));
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Plank not created"));
        }
    }

    @Override
    public String getOne(Request req, Response res) {
        res.type(ResponseType.JSON.toString());

        System.out.println(req.params("plankId"));
        int plankId = Integer.parseInt(req.params("plankId"));

        Plank plank = planksServices.getPlank(new Plank(plankId));

        if (plank != null) {
            return gson.toJson(plank);
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Plank not found"));
        }
    }

    @Override
    public String updateOne(Request req, Response res) {
        res.type(ResponseType.JSON.toString());

        OptiCutServicesAPI.logger.info("[PARAMS]: {}", req.params("plankId"));
        int plankId = Integer.parseInt(req.params("plankId"));

        String body = req.body();
        Plank plank = gson.fromJson(body, Plank.class);
        plank.setId(plankId);

        OptiCutServicesAPI.logger.info("[Update Plank]: {}", plank);

        int rowsAffected = planksServices.updatePlank(plank);

        if (rowsAffected != 0) {
            res.status(201);
            return gson.toJson(new OkResponse(201, "Plank updated"));
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Plank not updated"));
        }
    }

    @Override
    public String deleteOne(Request req, Response res) {
        res.type(ResponseType.JSON.toString());

        OptiCutServicesAPI.logger.info("[PARAMS]: {}", req.params("plankId"));
        int plankId = Integer.parseInt(req.params("plankId"));

        int rowsAffected = planksServices.deletePlank(new Plank(plankId));

        if (rowsAffected != 0) {
            res.status(201);
            return gson.toJson(new OkResponse(201, "Plank deleted"));
        } else {
            res.status(404);
            return gson.toJson(new ErrorResponse(404, "Plank not deleted"));
        }
    }
}
