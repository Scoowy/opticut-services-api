package com.opticortes.api;

import com.opticortes.controllers.GenericController;
import com.opticortes.controllers.ProductsController;
import com.opticortes.middlewares.CorsFilter;
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
        // Handler the error at init the Jetty Server
        Spark.initExceptionHandler(e -> {
            logger.error("[INIT ERROR]", e);
            System.exit(100);
        });

        // Set the port
        Spark.port(getPort());
        // Init manually the server
        Spark.init();

        // Adding the controllers
        ProductsController productsCtrl = new ProductsController();
        GenericController genericCtrl = new GenericController();

        // Set CORS
        Spark.before(new CorsFilter());

        // Todo: Return JSON of the API
        Spark.get("/", (request, response) -> "Todo bien!");

        // Routes of API
        Spark.path("/api", () -> {
            Spark.path("/products", () -> {
                Spark.path("/planks", () -> {
                    Spark.get("", productsCtrl::getAll);
                    Spark.post("", productsCtrl::addNew);
                    Spark.delete("", productsCtrl::deleteAll);

                    Spark.path("/:plankId", () -> {
                        Spark.get("", productsCtrl::getOne);
                        Spark.put("", productsCtrl::updateOne);
                        Spark.delete("", productsCtrl::deleteOne);
                    });
                });
            });
        });

        // Default route in not found resource
        Spark.notFound(genericCtrl::resourceNotFound);

        // Default route in unknown error occurring
        Spark.internalServerError(genericCtrl::unknownError);
    }

    static int getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8080;
    }
}
