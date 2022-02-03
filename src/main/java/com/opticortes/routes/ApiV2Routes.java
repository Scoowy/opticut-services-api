package com.opticortes.routes;

import spark.RouteGroup;
import spark.Spark;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.12.09.1836
 */
public class ApiV2Routes implements RouteGroup {
    @Override
    public void addRoutes() {
        Spark.path("/products", () -> {
            Spark.path("/planks", new PlankRoutes());
            Spark.path("/edges", ()->{});
        });
    }
}
