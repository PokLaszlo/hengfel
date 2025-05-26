package com.example;

import javafx.beans.property.SimpleDoubleProperty;

public class Cylinder {
    private final SimpleDoubleProperty radius;
    private final SimpleDoubleProperty height;
    private final SimpleDoubleProperty surface;

    public Cylinder(SimpleDoubleProperty radius, SimpleDoubleProperty height, SimpleDoubleProperty surface) {
        this.radius = radius;
        this.height = height;
        this.surface = surface;
    }
    public Cylinder(Double radius, Double height, Double surface) {
        this.radius = new SimpleDoubleProperty(radius);
        this.height = new SimpleDoubleProperty(height);
        this.surface = new SimpleDoubleProperty(surface);
    }

    public SimpleDoubleProperty radiusProperty() {
        return radius;
    }

    public SimpleDoubleProperty heightProperty() {
        return height;
    }

    public SimpleDoubleProperty surfaceProperty() {
        return surface;
    }
}
