package com.opticortes.dao;

import com.opticortes.api.OptiCutServicesAPI;
import com.opticortes.data.ConnectionSQL;
import com.opticortes.entities.Plank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1940
 */
public class PlankDAO implements ICRUD<Plank> {
    private Connection conn;

    private static final String SQL_SELECT = "SELECT id, name, height, width, density, active FROM planks";
    private static final String SQL_SELECT_ONE = "SELECT id, name, height, width, density, active FROM planks WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO planks(name, height, width, density, active) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE planks SET name = ?, height = ?, width = ?, density = ?, active = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM planks WHERE id = ?";

    public PlankDAO() {
    }

    public PlankDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Plank> selectAll() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        List<Plank> planks = new ArrayList<>();

        try {
            conn = this.conn != null ? this.conn : ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            OptiCutServicesAPI.logger.info("[QUERY]: {}", SQL_SELECT);
            res = stmt.executeQuery();

            for (ResultSet rs : List.of(res)) {
                rs.next();
                Plank plank = new Plank(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("height"),
                        rs.getDouble("width"),
                        rs.getDouble("density"),
                        rs.getBoolean("active")
                );
                planks.add(plank);
            }
        } finally {
            assert res != null;
            ConnectionSQL.close(res);
            ConnectionSQL.close(stmt);

            if (this.conn == null) {
                ConnectionSQL.close(conn);
            }
        }

        return planks;
    }

    @Override
    public int deleteAll() throws SQLException {
        return 0;
    }

    @Override
    public Plank select(Plank entity) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Plank plank = null;

        try {
            conn = this.conn != null ? this.conn : ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ONE);
            OptiCutServicesAPI.logger.info("[QUERY]: {}", SQL_SELECT_ONE);

            stmt.setInt(1, entity.getId());
            System.out.println(stmt);
            res = stmt.executeQuery();

            res.next();
            plank = new Plank(
                    res.getInt("id"),
                    res.getString("name"),
                    res.getDouble("height"),
                    res.getDouble("width"),
                    res.getDouble("density"),
                    res.getBoolean("active")
            );


        } finally {
            assert res != null;
            ConnectionSQL.close(res);
            ConnectionSQL.close(stmt);

            if (this.conn == null) {
                ConnectionSQL.close(conn);
            }
        }

        return plank;
    }

    @Override
    public int insert(Plank entity) throws SQLException {
        return 0;
    }

    @Override
    public int update(Plank entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Plank entity) throws SQLException {
        return 0;
    }
}
