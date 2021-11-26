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

            OptiCutServicesAPI.logger.info("[QUERY]: {}", stmt);

            res = stmt.executeQuery();

            while (res.next()) {
                Plank plank = new Plank(
                        res.getInt("id"),
                        res.getString("name"),
                        res.getDouble("height"),
                        res.getDouble("width"),
                        res.getDouble("density"),
                        res.getBoolean("active")
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

            stmt.setInt(1, entity.getId());

            OptiCutServicesAPI.logger.info("[QUERY]: {}", stmt);

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
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected = 0;

        try {
            conn = this.conn != null ? this.conn : ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, entity.getName());
            stmt.setDouble(2, entity.getHeight());
            stmt.setDouble(3, entity.getWidth());
            stmt.setDouble(4, entity.getDensity());
            stmt.setBoolean(5, entity.isActive());

            OptiCutServicesAPI.logger.info("[QUERY]: {}", stmt);

            rowsAffected = stmt.executeUpdate();

        } finally {
            ConnectionSQL.close(stmt);

            if (this.conn == null) {
                ConnectionSQL.close(conn);
            }
        }

        return rowsAffected;
    }

    @Override
    public int update(Plank entity) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected;

        try {
            conn = this.conn != null ? this.conn : ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, entity.getName());
            stmt.setDouble(2, entity.getHeight());
            stmt.setDouble(3, entity.getWidth());
            stmt.setDouble(4, entity.getDensity());
            stmt.setBoolean(5, entity.isActive());
            stmt.setInt(6, entity.getId());

            OptiCutServicesAPI.logger.info("[QUERY]: {}", stmt);

            rowsAffected = stmt.executeUpdate();

        } finally {
            ConnectionSQL.close(stmt);

            if (this.conn == null) {
                ConnectionSQL.close(conn);
            }
        }

        return rowsAffected;
    }

    @Override
    public int delete(Plank entity) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowsAffected;

        try {
            conn = this.conn != null ? this.conn : ConnectionSQL.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, entity.getId());

            OptiCutServicesAPI.logger.info("[QUERY]: {}", stmt);

            rowsAffected = stmt.executeUpdate();

        } finally {
            ConnectionSQL.close(stmt);

            if (this.conn == null) {
                ConnectionSQL.close(conn);
            }
        }

        return rowsAffected;
    }
}
