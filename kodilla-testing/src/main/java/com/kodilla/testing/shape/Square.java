package com.kodilla.testing.shape;

import java.util.Objects;

import static java.lang.Math.pow;

public class Square implements Shape {
    private String shapeName;
    private double sideLength;

    public Square(double sideLength) {
        this.shapeName = "Square";
        this.sideLength = sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Square)) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return sideLength == square.sideLength &&
                Objects.equals(shapeName, square.shapeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapeName, sideLength);
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double getField() {
        return pow(sideLength, 2);
    }

    @Override
    public String toString() {
        return "Square{" +
                "shapeName='" + shapeName + '\'' +
                ", field=" + sideLength +
                '}';
    }
}
