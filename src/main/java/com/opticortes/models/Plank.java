package com.opticortes.models;

import java.util.StringJoiner;

/**
 * Class
 *
 * @author Scoowy
 * @version 2021.11.22.1719
 */
public class Plank {
    private int id;
    private String name;
    private double height;
    private double width;
    private double density;
    private boolean active;

    public Plank() {
    }

    public Plank(int id) {
        this.id = id;
    }

    public Plank(String name, double height, double width, double density, boolean active) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.density = density;
        this.active = active;
    }

    public Plank(int id, String name, double height, double width, double density, boolean active) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.width = width;
        this.density = density;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Plank.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("height=" + height)
                .add("width=" + width)
                .add("density=" + density)
                .add("active=" + active)
                .toString();
    }
}
