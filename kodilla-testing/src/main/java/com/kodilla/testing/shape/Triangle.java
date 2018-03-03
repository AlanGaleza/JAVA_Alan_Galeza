package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {
    private String shapeName;
    private final double sideLength;
    private final double height;

    public Triangle(final double sideLength, final double height) {
        this.shapeName = "Triangle";
        this.sideLength = sideLength;
        this.height = height;
    }

    public double getField() { return (sideLength*height)/2; }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "shapeName='" + shapeName + '\'' +
                ", sideLength=" + sideLength +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.sideLength, sideLength) == 0 &&
                Double.compare(triangle.height, height) == 0 &&
                Objects.equals(shapeName, triangle.shapeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapeName, sideLength, height);
    }
}
