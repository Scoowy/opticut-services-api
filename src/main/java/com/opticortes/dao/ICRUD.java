package com.opticortes.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1933
 */
public interface ICRUD<T> {
    List<T> selectAll() throws SQLException;

    int deleteAll() throws SQLException;

    T select(T entity) throws SQLException;

    int insert(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(T entity) throws SQLException;
}
