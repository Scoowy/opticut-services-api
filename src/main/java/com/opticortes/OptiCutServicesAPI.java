package com.opticortes;

import spark.Spark;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1544
 */
public class OptiCutServicesAPI {
    public static void main(String[] args) {
        Spark.port(getPort());

        Spark.get("/", (request, response) -> "Todo bien!");

        Spark.path("/api", () -> {
            Spark.path("/products", () -> {
                Spark.path("/planks", () -> {
                    Spark.get("", (request, response) -> "Get all Planks");
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
