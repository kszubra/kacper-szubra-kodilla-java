package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private String shapeName;
    private int flank;
    private int height;

    public Triangle(int flank, int height) {
        this.shapeName = "Triangle";
        this.flank = flank;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return 0.5*flank*height;
    }
}
