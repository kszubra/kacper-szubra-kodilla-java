package com.kodilla.testing.shape;

public class Circle implements Shape {

    private String shapeName;
    private int radius;

    public Circle(int radius) {
        this.shapeName = "Circle";
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return 3.14*radius*radius;
    }
}
