package com.opticortes.utils;

import java.util.Map;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.2034
 */
public class ConfigDB {
    private static final ProcessBuilder processBuilder = new ProcessBuilder();
    private static final Map<String, String> env = processBuilder.environment();

    public static final String DB_HOST = env.get("DB_HOST") != null ? env.get("DB_HOST") : "0.0.0.0";
    public static final String DB_DATABASE = env.get("DB_DATABASE") != null ? env.get("DB_DATABASE") : "sys";
    public static final String DB_PORT = env.get("DB_PORT") != null ? env.get("DB_PORT") : "3306";
    public static final String DB_USER = env.get("DB_USER") != null ? env.get("DB_USER") : "root";
    public static final String DB_PASSWORD = env.get("DB_PASSWORD") != null ? env.get("DB_PASSWORD") : "";
}
