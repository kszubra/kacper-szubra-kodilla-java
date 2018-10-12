package com.kodilla.testing.shape;

public class Square implements Shape {

    private String shapeName;
    private int flank;

    public Square(int flank) {
        this.shapeName = "Square";
        this.flank = flank;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return flank*flank;
    }
}
