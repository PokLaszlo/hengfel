/*
* File: Cylinder.java
* Author: Pók László
* Copyright: 2025, Pók László
* Group: Szoft I/N
* Date: 2025-05-26
* Github: https://github.com/poklaszlo/
* Licenc: MIT
*/
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
