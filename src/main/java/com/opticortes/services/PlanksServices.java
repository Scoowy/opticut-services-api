package com.opticortes.services;

import com.opticortes.api.OptiCutServicesAPI;
import com.opticortes.dao.PlankDAO;
import com.opticortes.data.ConnectionSQL;
import com.opticortes.entities.Plank;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1728
 */
public class PlanksServices {
    Connection conn = null;

    public List<Plank> getPlanks() {
        List<Plank> planks = new ArrayList<>();
        try {
            planks = new PlankDAO().selectAll();
        } catch (SQLException e) {
            OptiCutServicesAPI.logger.error("[ERROR]:", e);
        }
        return planks;
    }

    public Plank getPlank(Plank plank) {
        Plank selectedPlank = null;

        try {
            selectedPlank = new PlankDAO().select(plank);
        } catch (SQLException e) {
            OptiCutServicesAPI.logger.error("[ERROR]", e);
        }

        return selectedPlank;
    }

}
