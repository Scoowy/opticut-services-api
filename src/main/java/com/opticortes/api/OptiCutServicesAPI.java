package com.opticortes.api;

import com.opticortes.controllers.ProductsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1544
 */
public class OptiCutServicesAPI {

    public final static Logger logger = LoggerFactory.getLogger(OptiCutServicesAPI.class);

    public static void main(String[] args) {
        Spark.port(getPort());

        ProductsController productsCtrl = new ProductsController();

        Spark.get("/", (request, response) -> "Todo bien!");

        Spark.path("/api", () -> {
            Spark.path("/products", () -> {
                Spark.path("/planks", () -> {
                    Spark.get("", productsCtrl::getAll);
                    Spark.post("", (request, response) -> "Nueva plancha");
                    Spark.delete("", (request, response) -> "Borrar todas las planchas");

                    Spark.path("/:idPlank", () -> {
                        Spark.get("", (request, response) -> "Obteniendo una plancha");
                        Spark.put("", (request, response) -> "Actualizando una plancha");
                        Spark.delete("", (request, response) -> "Eliminando una plancha");
                    });
                });
            });
        });
    }

    static int getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080;
    }
}
