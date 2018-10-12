package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeList;

    public ShapeCollector() {
        this.shapeList = new ArrayList<Shape>();
    }

    public void addFigure(Shape shape){
        shapeList.add(shape);
    }

    public int getShapesAmount(){
        return shapeList.size();
    }

    public void removeFigure(Shape shape){
        shapeList.remove(shape);
    }

    public Shape getFigure(int n){
        return shapeList.get(n);
    }

    public void showFigures(){
        for (Shape shape : shapeList) {
            System.out.println("Shape: " + shape.getShapeName() + " Field: " + shape.getField());
        }
    }

}
