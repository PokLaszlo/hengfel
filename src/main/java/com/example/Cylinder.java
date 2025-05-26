package com.example;

public class Cylinder {
    private Double radius;
    private Double height;
    private Double surface;

    public Cylinder(Double radius, Double height, Double surface) {
        this.radius = radius;
        this.height = height;
        this.surface = surface;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getHeight() {
        return height;
    }    

    public void setHeight(Double height) {
        this.height = height;
    }    

    public Double getSurface() {
        return surface;
    }
    public void setSurface(Double surface) {
        this.surface = surface;
    }
}
