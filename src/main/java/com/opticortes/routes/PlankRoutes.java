package com.opticortes.routes;

import com.opticortes.controllers.ProductsController;
import spark.RouteGroup;
import spark.Spark;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.12.09.1736
 */
public class PlankRoutes implements RouteGroup {

    private final ProductsController productsCtrl = new ProductsController();

    @Override
    public void addRoutes() {
        Spark.get("", productsCtrl::getAll);
        Spark.post("", productsCtrl::addNew);
        Spark.delete("", productsCtrl::deleteAll);

        Spark.path("/:plankId", () -> {
            Spark.get("", productsCtrl::getOne);
            Spark.put("", productsCtrl::updateOne);
            Spark.delete("", productsCtrl::deleteOne);
        });
    }
}
