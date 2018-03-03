package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    List<Shape> shapeCollector = new ArrayList<>();

    public void addShapeToArrayList(Shape shape) {
        shapeCollector.add(shape);
    }

    public boolean removeShapeFromArrayList(Shape shape) {
        return shapeCollector.remove(shape);
    }

    public Shape getShapeFromArrayList(int number) {
        return shapeCollector.get(number);
    }

    public int getListSize() {
        return shapeCollector.size();
    }
}
